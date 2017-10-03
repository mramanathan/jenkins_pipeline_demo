node {
	stage('YAML Parse') {
		dir("YML") {
			 deleteDir()
	        	 git url: 'https://github.com/mramanathan/jenkins_pipeline_demo.git', branch: 'readyaml'
    			 def yamlcfg = readYaml file: 'test.yml'
    			 println "YML contents " + yamlcfg
			 awsecr = yamlcfg["aws_ecr"]
			 vmharbor = yamlcfg["vmware_harbor"]

			 if ( awsecr["active"] == "yes" ) {
			 	println "AWS ECR configs: "
				println "AWS ECR, " + awsecr["repo_name"]
				println "AWS account, " + awsecr["account"]
				println "AWS ECR URI, " + awsecr["repo_uri"]
			 }

			 if ( vmharbor["active"] == "yes" ) {
			 	println "VMWare Harbor configs: "
				println vmharbor["repo_name"]
				println vmharbor["account"]
				println vmharbor["repo_uri"]
			 }

		}
	}
}
