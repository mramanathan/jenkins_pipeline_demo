node {
    // Spit out timestamps in console log for each step in various stages
    timestamps {
      stage("JSON Lint") {
        dir('extgroovy') {
          deleteDir()
          git url: 'https://github.com/mramanathan/jenkins_pipeline_demo', branch: 'callgroovy'
          sh 'sudo -H apt-get install -qq python-demjson'
          def jsonfile = "test.json"
          def json = load "json.groovy"
          def lint_status = json.jsonLint("${jsonfile}")
          echo "Status of json lint, ${lint_status}"
        }
      }
    }
}
