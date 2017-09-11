node {
    // Spit out timestamps in console log for each step in various stages
    timestamps {
      stage("JSON Lint") {
        def jsonfile = "test.json"
        def json = load "json.groovy"
        json.jsonLint("${jsonfile}")
      }
    }
}
