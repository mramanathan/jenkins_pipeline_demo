// This shows a simple build wrapper example, using the Timestamper plugin.
// node('master') ==
//                 \/
//                  same as node
stage("Collect Build Info") {
	
	// node nested inside stage
	node ('master') {

		timestamps {
			try {
				// Extract basic build details
				env.build_branch = env.BRANCH_NAME
				env.build_link   = env.JOB_URL
				env.commit_id    = env.CHANGE_ID
				env.author       = env.CHANGE_AUTHOR
			catch(error)
				echo "Build details could not be gathered."
			}
		}
	}
}

node {
	// Spit out timestamps in console log for each step in various stages
	timestamps {

		echo "Git commit, ${commit_id} by ${author} on ${build_branch} triggered a fresh build"
		echo "This build can be accessed via, ${build_link}"

		// Just some echoes to show the timestamps.
		stage('SysInfo') {

			echo "Running on host --"
			// Exclude excessive output from console logs
			sh ('#!/bin/sh -e\n' + "echo `hostname`")
			echo "OS Version : "
			sh "pg /etc/debian_version"

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
