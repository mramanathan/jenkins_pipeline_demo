#!/bin/bash

# rundeck cli installed in Jenkins master
# Inputs : project name + job UUID + manifest file
# check build job or in rundeck for job log
## ========
# Howto overcome this via pipeline script ? using withEnv ??
## ========
export RD_URL=http://54.244.109.48:4440/api/17
export RD_USER=admin
export RD_PASSWORD=admin
rd run -p sampleme -i d48b9f5b-4765-4e1f-b53b-f527d44e6af9 -- -ARG1 patch_manifest
