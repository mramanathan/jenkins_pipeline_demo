#!groovy

def call(body) {

    sh 'git rev-parse HEAD > commit_id'

    try {
        env.COMMIT_ID = readFile('commit_id').trim()
    } catch (FileNotFoundException e) {
        return
    }
}
