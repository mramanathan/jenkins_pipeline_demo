#!groovy

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node('linux') {
        checkout scm
        def url = "https://github.com/jenkinsci/${config.name}-plugin.git"
        echo " == URL with repo name == "
        echo "${url}"
    }
}
