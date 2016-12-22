#!groovy

class buildUtils {
    def call() {
        sh 'git rev-parse HEAD > commit_id'
                env.COMMIT_ID = readFile('commit_id').trim()
   }
}
