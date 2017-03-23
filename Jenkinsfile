node('master') {
  // Spit out timestamps in console log for each step in various stages
  timestamps {
    goBuild {
      environment = "golang:1.6"
      buildscript='''
        go version
        go build -v /home/ubuntu/hello.go"
        /home/ubuntu/hello
      '''
    }
  }
}

