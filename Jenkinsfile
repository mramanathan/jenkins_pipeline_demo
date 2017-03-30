node ('linux') {

/* what's the diff between this and git url... ?
   git url allows more granularity interms of branch filetring, supplying credentials . . . */
// checkout scm

  // Very useful workaround in multi-branch pipeline setup
  // https://support.cloudbees.com/hc/en-us/articles/226122247-How-to-Customize-Checkout-for-Pipeline-Multibranch
  stage('Workspace Preparation') {
    checkout([
      $class: 'GitSCM', 
      branches: [[name: '*/master']], 
      doGenerateSubmoduleConfigurations: false, 
      extensions: [], 
      submoduleCfg: [], 
      userRemoteConfigs: [[credentialsId: 'ram_github_creds', url: 'https://github.com/mramanathan/jenkins_pipeline_demo']]
    ])
  }

  stage('Commit Info') {
    def commit_id = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
    env.short_id  = commit_id.take(7)
    // changeset associated with this commit
    def file_name = sh(returnStdout: true, script: 'git log -1 --abbrev-commit --pretty=oneline --name-only | tail -n 1')
    echo "~> changeset, ${file_name}"
    echo "~> commit id, ${short_id}"
  }
}
			
/* Exclude excessive output from console logs
sh ('#!/bin/sh -e\n' + "echo `hostname`")

// Example for nested stages
stage(" =~=~= Python Info!!! =~=~= ") {
    pkginfo 'python'
}


def pkginfo(pkgname) {
 
   echo "Trying to find details of ${pkgname} package"
   sh("dpkg-query -s ${pkgname}")

} */

