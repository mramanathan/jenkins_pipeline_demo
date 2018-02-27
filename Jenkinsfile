pipeline {
    agent any
    options {
        timestamps()
    }
    stages {
        stage('prep') {
            steps {
                script {
                    echo "are these env vars populated?"
                    sh 'printenv'
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
