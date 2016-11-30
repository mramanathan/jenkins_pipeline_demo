// This shows a simple build wrapper example, using the Timestamper plugin.
node {
	// Spit out timestamps in console log for each step in various stages
	timestamps {

		// Just some echoes to show the timestamps.
		stage('SysInfo') {
		    echo "Running on host --"
		    // Exclude excessive output from console logs
		    sh ('#!/bin/sh -e\n' + "echo `hostname`")
		    echo "OS Version : "
		    sh "pg /etc/debian_version"
		}

		// Placeholder to store build output
		stage("Build Output...") {
		    sh ("mkdir -p output")
		}

		// Method to generate artifacts
		stage("Writing build artefacts") {
		    writeFile file: "output/README.txt", text: "What's the intent & content of this archive ?\n Sampling artifact generator."
		}

		stage("Generating test artefact") {
		    archiveArtifacts artifacts: 'output/*.txt
		}
        }
}
