node {
	stage('YAML Parse') {
		dir("YML") {
			 deleteDir()
	        	 git url: 'https://github.com/mramanathan/jenkins_pipeline_demo.git', branch: 'readyaml'
    			 def yamlcfg = readYaml file: 'test.yml'
    			 println "YML contents " + yamlcfg
		}
	}
}
