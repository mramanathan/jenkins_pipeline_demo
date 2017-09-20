properties([
  parameters([
    string(defaultValue: '', description: '', name: 'CFG_FILE')
    ]),
  pipelineTriggers([])
])

if ( "${params.CFG_FILE}" ) {
    node {
        stage('Param Prep') {
    		dir('sandbox') {
                deleteDir()

    			git url: 'https://github.com/mramanathan/jenkins_pipeline_demo', branch: 'triggerme_onparams'

                echo "~> This is from build job that was triggered with parameter set as ${params.CFG_FILE}"
            }
        }
    }
} else {
    node {
        stage('Prep') {
    		dir('sandbox') {
			deleteDir()

    			git url: 'https://github.com/mramanathan/jenkins_pipeline_demo', branch: 'triggerme_onparams'

			env.gitCommit = sh(returnStdout: true, script: 'git rev-parse --verify HEAD --short=9').trim()
			echo "git commit id, ${env.gitCommit}"

			env.gitChangeset = sh(returnStdout: true, script: 'git log -m -1 --name-only --pretty=\"format:\" HEAD').trim()
			echo "git changeset with path, ${env.gitChangeset}"

			echo "~> This is from build job that was triggered from git changeset."

			if ( "${env.gitChangeset}" =~ /.json$/ ) {
			    echo "~> Detected JSON in git changeset, so, will trigger a fresh build job of the same project with param set to JSON."
			    build job: 'triggerme', parameters: [string(name: 'CFG_FILE', value: 'test.json')], propagate: false, quietPeriod: 45, wait: false
			} else {
			    echo "~> No JSON in the git changeset, so, no fresh build job triggered."
			}
        	}
        }
    }
}
