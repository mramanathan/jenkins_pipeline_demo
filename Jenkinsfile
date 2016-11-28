// This shows a simple build wrapper example, using the Timestamper plugin.
node {
        // Just some echoes to show the timestamps.
        stage('Gathering system info') {
        
            echo "Running on host...!"
            // Exclude excessive console logging
            sh ('#!/bin/sh -e\n' + " echo `hostname` ")
            echo "OS Version : "
            sh "pg /etc/debian_version"
        }

        // A sleep to make sure we actually get a real difference!
        stage('Sleeping') {
            sh "sleep 10"
        }

        // And a final echo to show the time when we wrap up.
        stage('User Prompting!!!') {
            input message: "Are you ready?"
        }
}
