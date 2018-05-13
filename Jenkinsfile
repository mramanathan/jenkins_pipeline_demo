node {
	timestamps {
		stage('Embed') {
			checkout scm
			
			sh '''#!/usr/bin/env python

import os

print(os.environ["PATH"])
			'''
		}
	}
}
