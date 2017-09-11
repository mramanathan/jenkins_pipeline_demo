#!/usr/bin/groovy

def jsonLint(String jsonfile) {

  echo "JSON file to lint, ${jsonfile}"

  def lint_status = sh(returnStatus: true, script: "jsonlint-py ${jsonfile}")

  echo "JSON lint status, ${lint_status}"

}

return this
