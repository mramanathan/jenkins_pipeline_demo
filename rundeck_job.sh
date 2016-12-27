#!/bin/bash

# rundeck cli installed in Jenkins master
# Inputs : project name + job UUID + manifest file
# check build job or in rundeck for job log
## ========
# Howto overcome this via pipeline script ? using withEnv ??
## ========
export RD_URL=http://54.202.181.216:4440/api/17
#export RD_USER=admin
#export RD_PASSWORD=admin
export RD_TOKEN=SBrHrDFwDHr9PMcBI1V3AsKhk6YoIf3J
rd run -p ansible_play -i 5c970e5b-8d36-4a28-8b5f-905a9c81949e  -- -ARG1 patch_manifest
