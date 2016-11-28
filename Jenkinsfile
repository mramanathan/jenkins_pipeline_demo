// This shows a simple build wrapper example, using the Timestamper plugin.
node {
        // Just some echoes to show the timestamps.
        stage('SysInfo') {
        
            echo "Running on host --"
            // Exclude excessive output from console logs
            sh ('#!/bin/sh -e\n' + "echo `hostname`")
            echo "OS Version : "
            sh "pg /etc/debian_version"
        }

	// Can embed external scripts like this ?
        stage("Python Status") {
            // clone contents of repo from specific branch, default ~> master
            git ([url: "https://github.com/mramanathan/jenkins_pipeline_demo.git", branch: 'master'])
	    echo "Current working directory: "
	    sh "pwd"
            sh ('#!/bin/sh -e\n' + "sh ./check_python_pkgs.sh")
        }

        // A sleep to make sure we actually get a real difference!
        stage('Sleeping') {
            sh "sleep 15"
        }

        // And a final echo to show the time when we wrap up.
        stage('User prompting!!!') {
            input message: "Are you ready?"
        }
}
