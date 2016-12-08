// This shows a simple build wrapper example, using the Timestamper plugin.
// node('master') ==
//                 \/
//                  same as node
// Simple echo without 'node' context
stage name: "Nodeless Sample Stage"
echo 'Hello Pipeline World!!!'

stage("Collect Build Info") {
	
	// node nested inside stage
	node ('master') {

		timestamps {
			
			// what's the diff between this and git url... ?
			checkout scm

			try {
				// Extract basic build details
				env.build_branch = env.BRANCH_NAME
				env.build_link   = env.JOB_URL
			} catch(error) {
				throw error
			} finally {
				echo "Build details were gathered."
			}
		}
	}
}

node {
	// Spit out timestamps in console log for each step in various stages
	timestamps {

		// clone contents of repo from specific branch, default ~> master
		// Why another cloning ? else, git rev-parse complains it's not inside repo
		// need to read doc and re-try later
		/* git clone and run git rev-parse on HEAD
		git ([url: "https://github.com/mramanathan/jenkins_pipeline_demo.git", branch: 'trials'])
		def commit_id = sh(returnStdout: true, script: 'git rev-parse --verify HEAD').trim()
		def short_id  = commit_id.take(7)
		echo "${short_id}" 
		*/

		git ([url: "https://github.com/mramanathan/jenkins_pipeline_demo.git", branch: 'trials'])
		stash name: "trial-sources", includes: "*/*"

		echo "Fresh build on branch, ${build_branch} has been triggered by the following commits -- "
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

