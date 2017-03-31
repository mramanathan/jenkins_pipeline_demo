node {

  stage('Start Clean') {
    deleteDir()
  }

  // Very useful workaround in multi-branch pipeline setup
  // https://support.cloudbees.com/hc/en-us/articles/226122247-How-to-Customize-Checkout-for-Pipeline-Multibranch
  // "branches: " can be different from the one set in job config, this is a overriding option
  stage('Workspace Preparation') {
    checkout([
      $class: 'GitSCM', 
      branches: [[name: 'refs/remotes/origin/trials']], 
      doGenerateSubmoduleConfigurations: false, 
      extensions: [], 
      submoduleCfg: [], 
      userRemoteConfigs: [[credentialsId: 'ram_github_creds', url: 'https://github.com/mramanathan/jenkins_pipeline_demo']]
    ])
  }

  // stash sources for use in parallel construct
  stash name: 'scripts-sources'

  parallel (

    'Commit Info': {
       def commit_id = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
       env.short_id  = commit_id.take(7)
       // changeset associated with this commit
       def changeset = sh(returnStdout: true, script: 'git diff-tree --no-commit-id --name-only HEAD').trim()
       // remember to approve 'scm.branches' script by your Jenkins administrator
       println "~> Branch referenced for this build, ${scm.branches}"
       println "~> changeset associated with commit, ${short_id}:"
       println "${changeset}"
       sh "sleep 5s"
    },

    'Sys Info': {
       sh "uname -a"
    }

    'Go Compile': {
       node('master') {
         unstash 'scripts-sources'
         dir('scripts') {
           sh "go run welcome.go"
         }
       }
    }
  )

  // reusing function defined outside 'node' block
  stage(" Python Info ") {
      pkginfo 'python'
  }

}

def pkginfo(pkgname) {
   echo "Trying to find details of ${pkgname} package"
   sh("dpkg-query -s ${pkgname}")
} 

/* Exclude excessive output from console logs
sh ('#!/bin/sh -e\n' + "echo `hostname`") */
