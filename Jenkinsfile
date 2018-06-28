node {
  stage('test') {
    withEnv(["IO_APPLICATION_CONTAINER_LIST=
            fireeye-endpoint-app_proc-v1-develop \
            fireeye-ingress-app_proc-v2-develop"
           ]) {
      sh 'printenv'
    }
  }
}
