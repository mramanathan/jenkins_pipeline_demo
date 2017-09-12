node {
    // Spit out timestamps in console log for each step in various stages
    timestamps {
      stage("JSON Lint") {
        dir('extgroovy') {
          deleteDir()
          git url: 'https://github.com/mramanathan/jenkins_pipeline_demo', branch: 'callgroovy'
          def jsonfile = "test.json"
          def json = load "json.groovy"
          lintok = json.jsonLint("${jsonfile}")
          echo "Status of json lint, ${lintok}"
          /*
          json.jsonLint("${jsonfile}")
          echo "Status of json lint, ${env.lint_status}"
          */
        }
      }
    }
}
