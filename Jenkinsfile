node('ubuntu') {
  timestamps {

    stage('Start Clean') {
      deleteDir()
    }

    stage('Git Tasks') {
      // git commands need context i.e. directory with .git to run...
      // In your jenkins master, credentials ID will be different from the one used here, so make necessary changes...
      git url: 'https://github.com/mramanathan/jenkins_pipeline_demo', credentialsId: 'ram_github_creds'
      gitInfo {
        // tagname --> should be able to handle as input parameter
        tagname = 'GIT_WORKFLOW_LIB_V17.03.28.00.01'
        wsdir = '${WORKSPACE}'
      }
    }

    stage('Start Clean') {
      deleteDir()
    }
  }
}
