node('master') {
    stage(" == Simple Stage == ") {
        helloWorld("Jenkins")
    }
    stage(" == Git Util == ") {
        buildUtils("jenkins-infra-stdlibs")
    }
}

node {

  stage('Start Clean') {
    deleteDir()
  }

  stage('Git Info') {
    gitInfo() {
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
