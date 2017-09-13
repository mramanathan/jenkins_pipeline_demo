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


def cfgDeploy(String ymlfile) {

    echo "~> YML file to deploy, ${ymlfile}"
    def cfgdeploy_status = "OKAY"
    echo "~> YML lint status, ${cfgdeploy_status}"

    return cfgdeploy_status

}


def lint_deploy(String ymlfile) {
    timeout(time: 120, unit: 'SECONDS') {
            def ymllint_status = ""
            def cfgdeploy_status = ""

            stage('Lint') {
                try {
                    ymllint_status = lintYml("${ymlfile}")
                    echo "YAML lint status, ${ymllint_status}"
                } catch (Exception err) {
                    ymllint_status = "NOT DONE"
                    echo "~> YAML lint status, ${ymllint_status}"
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
            }

            stage('Deploy') {
                try {
                    cfgdeploy_status = cfgDeploy("${ymlfile}")
                    echo "cfg deploy status, ${cfgdeploy_status}"
                } catch (Exception err) {
                    cfgdeploy_status = "NOT DONE"
                    echo "~> cfg deploy status, ${cfgdeploy_status}"
                    throw err
                }

                if ( "${cfgdeploy_status}" == "OKAY" ) {
                    echo "~> ${ymlfile} deploy PASSED"
                    currentBuild.result = "SUCCESS"
                    return
                }
                if ( "${cfgdeploy_status}" == "YAKO" ) {
                    echo "~> ${ymlfile} deploy FAILED"
                    currentBuild.result = "FAILURE"
                    return
                }
            }
    }
}

return this
