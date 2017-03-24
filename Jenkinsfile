node('ubuntu') {
  // Spit out timestamps in console log for each step in various stages
  timestamps {
      stage('Start Clean') {
        deleteDir()
        checkout scm
      }

      stage('Go Build') {
        /* == pull golang v1.6 docker image and generate hello binary
              from hello.go program == */
        goBuild {
          environment = "golang:1.6"
          buildScript='''
            go version
            go build -v hello.go
            ./hello
          '''
        }
      }
  }
}

