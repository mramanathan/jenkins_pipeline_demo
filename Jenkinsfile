pipeline {
    agent any
    options {
        timestamps()
    }
    environment {
        IMAGE = "custom-tutum"
    }
    stages {
        stage('prep') {
            steps {
                script {
                    env.GIT_HASH = sh(
                        script: "git show --oneline | head -1 | cut -d' ' -f1",
                        returnStdout: true
                    ).trim()
                }
            }
        }
        stage('build') {
            steps {
                script {
                    image = docker.build("${IMAGE}")
                    println "Newly generated image, " + image.id
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // https://hub.docker.com/r/tutum/hello-world/
                    def container = tutum_image.run('-p 80')
                    println image.id + " container is running at host port, " + container.port(80)
                    image.tag("${GIT_HASH}")
                    if ( "${env.BRANCH_NAME}" == "master" ) {
                        image.tag("LATEST")
                    }
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
