#!/usr/bin/groovy

def jsonLint(String jsonfile) {

  echo "JSON file to lint, ${jsonfile}"

  sh 'which jsonlint'
  def lint_status = sh(returnStatus: true, script: 'jsonlint ${jsonfile}')

  echo "JSON lint status, ${lint_status}"

}

return this
