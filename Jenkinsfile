node {
	timestamps {
		stage('Embed') {
			checkout scm

			sh """#!/usr/bin/env python

import os

def demo_func(this_string):
	this_string = this_string.title()
	this_string = this_string.replace('Fox', 'Jackal')

	return this_string


print('Grab the current working dir, useful to track the directory context.')
print(os.environ['PWD'])

test_string = "The quick brown fox jumped over the lazy dog."
print("Before some string munging, ", test_string)

print "After some string munging, ", demo_func(test_string)
			"""

			currentBuild.displayName = "bangpypers-meetup-2018-may-demo_2"
		}
	}
}
