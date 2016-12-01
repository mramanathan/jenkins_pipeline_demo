// This shows a simple build wrapper example, using the Timestamper plugin.
// node('master') ==
//                 \/
//                  same as node
node {
	// Spit out timestamps in console log for each step in various stages
	timestamps {

		// Just some echoes to show the timestamps.
		stage('SysInfo') {

			steps {
			    echo "Running on host --"
			    // Exclude excessive output from console logs
			    sh ('#!/bin/sh -e\n' + "echo `hostname`")
			    echo "OS Version : "
			    sh "pg /etc/debian_version"
			}

			// Try calling a function to check pkg info
			stage("Python Info!!!") {
			    pkginfo 'python'
			}
		}
	}
}

def pkginfo(pkgname) {
 
   echo "Trying to find details of ${pkgname} package"
   sh("dpkg-query -s ${pkgname}")

}
