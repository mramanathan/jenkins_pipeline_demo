pipeline {
    agent any

    options {
        disableConcurrentBuilds()
    }

    stages {
        stage('Git-Token') {
            steps {
                ws("${WORKSPACE}/github_token") {
                    script {
                        withCredentials([string(credentialsId: 'c12d52bc-6e8d-4604-a663-7fc0cfbeadd5', variable: 'GHE_TOKEN')]) {
                            sh "git clone https://${GHE_TOKEN}@github.com/mramanathan/jenkins_pipeline_demo.git --branch github_token"
                            env.gitCommit  = sh(returnStdout: true, script: "cd jenkins_pipeline_demo && git rev-parse --verify HEAD").trim()
                            println "Latest commit's SHA1 id, ${gitCommit}"
                            env.remoteRepo = sh(returnStdout: true, script: "cd jenkins_pipeline_demo && git config --get remote.origin.url").trim()
                            println "URL of the remote, ${env.remoteRepo}"
                        }
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
