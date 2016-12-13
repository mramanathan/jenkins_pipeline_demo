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

			// not including include patterns, includes **
			stash name: "trial-sources"

			def commit_id = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
			env.short_id  = commit_id.take(7)

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

		echo "Fresh build on branch, ${build_branch} was triggered by the latest commit -- "
		echo "${short_id}"
		echo "This build can be accessed via, ${build_link}"

		// Just some echoes to show the timestamps.
		stage('SysInfo') {

			echo "Running on host --"
			// Exclude excessive output from console logs
			echo "Running on host : "
			sh ('#!/bin/sh -e\n' + "echo `hostname`")
			echo "OS Version : "
			sh "pg /etc/debian_version"

			// Try calling a function to check pkg info
			stage("Python Info!!!") {
			    pkginfo 'python'
			}
	
			stage("Collect Env vars...") {
			    printEnv()
			}
		}
	}
}

@NonCPS
def printEnv() {
	// Collect and print all env variables
	sh 'env > env_vars.txt'
	def envdump = readFile('env_vars.txt')
	echo "== START: Dump of enviroment variables =="
	echo "${envdump}"
	echo "== END: Dump of enviroment variables =="
	
	// TODO => Why isn't this loop printing ? needs further research...
	/* readFile('env_vars.txt').split("\r?\n").each {
		println it
	}
	*/
}


def pkginfo(pkgname) {
 
   echo "Trying to find details of ${pkgname} package"
   sh("dpkg-query -s ${pkgname}")

}

