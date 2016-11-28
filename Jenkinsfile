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
	    echo "Current working directory: "
	    sh "pwd"
            // clone contents of repo from specific branch, default ~> master
            // git ([url: "git://localhost/repo", branch: 'hostname'])
            sh "./check_python_pkgs.sh"
        }

        // A sleep to make sure we actually get a real difference!
        stage('Sleeping') {
            sh "sleep 15"
        }

        // And a final echo to show the time when we wrap up.
        stage('Cool Buddy!!!') {
            input message: "Are you ready?"
        }
}
