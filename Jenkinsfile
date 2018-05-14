node {
	timestamps {
		stage('Embed') {
			checkout scm

			sh """#!/usr/bin/env python

import os

print('Grab the current working dir, useful to switch dirs during the build flow.')
print(os.environ['PWD'])
			"""
		}
	}
}
