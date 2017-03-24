node('ubuntu') {
  // Spit out timestamps in console log for each step in various stages
  timestamps {
      /* == pull golang v1.6 docker image and generate hello binary
            from hello.go program == */
      goBuild {
        wsdir = ${WORKSPACE}
        environment = "golang:1.6"
        buildScript='''
          go version
          go build -v hello.go
          ./hello
        '''
      }

      def goResult = readFile('buildresult.txt').trim()

      if ( goResult == "PASS" ) {
        println "Go build passed !"
        currentBuild.result = "SUCCESS"
      } else if ( goResult == "FAIL" ) {
        println "Go build failed !"
        currentBuild.result = "FAILURE"
      } else {
        println "Go build unstable !"
        currentBuild.result = "UNSTABLE"
      }
  
      echo "Result of go build : ${currentBuild.result}"
  }
}

