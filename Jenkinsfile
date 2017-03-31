def startBuild(label, tool) {

  node(label) {

    timestamps { 

      stage('Start Clean') {
        deleteDir()
      }
  
      // Very useful workaround in multi-branch pipeline setup
      // https://support.cloudbees.com/hc/en-us/articles/226122247-How-to-Customize-Checkout-for-Pipeline-Multibranch
      // "branches: " can be different from the one set in job config, this is a overriding option
      stage('Workspace Preparation') {
        checkout([
          $class: 'GitSCM', 
          branches: [[name: 'refs/remotes/origin/parallel_construct']], 
          doGenerateSubmoduleConfigurations: false, 
          extensions: [], 
          submoduleCfg: [], 
          userRemoteConfigs: [[credentialsId: 'ram_github_creds', url: 'https://github.com/mramanathan/jenkins_pipeline_demo']]])
      }

      stage('Commit Info') {
        def commit_id = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
        env.short_id  = commit_id.take(7)
        // changeset associated with this commit
        def changeset = sh(returnStdout: true, script: 'git diff-tree --no-commit-id --name-only HEAD').trim()
        // remember to approve 'scm.branches' script by your Jenkins administrator
        println "~> Branch referenced for this build, ${scm.branches}"
        println "~> changeset associated with commit, ${short_id}:"
        println "${changeset}"
      }

      stage('Tool Info') {
        pkginfo tool
      }
    }
  }
}

configuration = [:]

def buildInit(label, tool) {
  def configLabel = label + '-' + tool
  configuration[configLabel] = { startBuild(label, tool) }
}

buildInit(master, python)
buildInit(master, golang-go)

parallel(configuration)


def pkginfo(pkgname) {
   echo "~> Trying to find details of ${pkgname} package"
   sh("dpkg-query -s ${pkgname}")
} 

