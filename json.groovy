#!/usr/bin/groovy

/*
  Lint YML file and return lint status
*/

def lintYml(String ymlfile) {

    echo "~> YML file to lint, ${ymlfile}"
    def ymllint_status = sh(returnStatus: true, script: "jsonlint-py ${ymlfile}")
    echo "~> YML lint status, ${ymllint_status}"

    return ymllint_status

}


def lint_deploy(String ymlfile) {
    timeout(time: 120, unit: 'SECONDS') {
        // waitUntil {
            def ymllint_status = ""

            try {
                ymllint_status = lintYml("${ymlfile}")
                echo "YAML lint status, ${ymllint_status}"
            } catch (Exception err) {
                ymllint_status = "NOT DONE"
                echo "~> YML lint status, ${ymllint_status}"
                throw err
            }

            if ( "${ymllint_status}" == "2" || "${ymllint_status}" == "0" ) {
                echo "~> ${ymlfile} linting PASSED"
                currentBuild.result = "SUCCESS"
                return
            } else {
                echo "~> ${ymlfile} linting FAILED"
                currentBuild.result = "FAILURE"
                return
            }
        // }
    }
}

return this
