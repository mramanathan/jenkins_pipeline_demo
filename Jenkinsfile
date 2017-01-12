node('master') {
	timestamps {
            stage('Capitals') {
              configFileProvider([configFile(field: 'capital_jsoncfg', variable: 'capitals_info')]) {
			echo " Path of config file : $capitals_info"
                        sh "cat $capitals_info"
              }
            }
        }
}
