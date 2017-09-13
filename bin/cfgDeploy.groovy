#!/usr/bin/groovy


def cfgDeploy(String ymlfile) {

    echo "~> YML file to deploy, ${ymlfile}"
    def cfgdeploy_status = "OKAY"
    echo "~> YML deploy status, ${cfgdeploy_status}"

    return cfgdeploy_status

}

return this
