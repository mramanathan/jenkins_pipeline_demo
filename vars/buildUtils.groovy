#!groovy

class buildUtils {
    def call() {

        sh 'git rev-parse HEAD > commit_id'

            try {
                env.COMMIT_ID = readFile('commit_id').trim()
	        echo "${COMMIT_ID}"
            } catch (FileNotFoundException e) {
                return
            }
   }
}
