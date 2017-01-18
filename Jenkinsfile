node('master') {
	timestamps {
            stage('Capitals') {
              configFileProvider([configFile(field: 'b65d558b-85d9-4592-bf17-09837f8b4ab9', variable: 'capitals_info')]) {
			echo " Path of config file : $capitals_info"
                        sh "cat $capitals_info"
              }
            }
        }
}
