node {
    // Spit out timestamps in console log for each step in various stages
  timestamps {
      ansicolor('xterm') {
        stage("JSON Lint") {
          dir('extgroovy') {
            deleteDir()
            git url: 'https://github.com/mramanathan/jenkins_pipeline_demo', branch: 'callgroovy'
            def jsonfile = "test.json"
            def json = load "json.groovy"
            lintok = json.jsonLint("${jsonfile}")
            echo "Status of json lint, ${lintok}"
          }
        }
      }
    }
}
