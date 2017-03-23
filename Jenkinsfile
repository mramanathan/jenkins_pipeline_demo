node('ubuntu') {
  // Spit out timestamps in console log for each step in various stages
  timestamps {
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

