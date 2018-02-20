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
