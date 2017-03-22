node {

  stage('Start Clean') {
    deleteDir()
  }

  stage(" == Simple Stage == ") {
     helloWorld("Jenkins")
  }

  /* stage(" == Git Util == ") {
        buildUtils("jenkins-infra-stdlibs")
  } */

  stage('Git Info') {
    // git commands need context i.e. directory with .git to run...
    git url: 'https://github.com/mramanathan/jenkins_pipeline_demo', credentialsId: 'ram_github_creds'
    gitInfo {
      wsdir = '${WORKSPACE}'
    }
  }

  withEnv(['IMGTOOL=/usr/neustar.biz/tools/bin/packer']) {
    stage('Collect Env...') {
      sh 'printenv'
    }
  }

  stage('Cleanup') {
    deleteDir()
  }

}
