#!/bin/bash

# rundeck cli installed in Jenkins master
# Inputs : project name + job UUID + manifest file
# check build job or in rundeck for job log
rd run -p sampleme -i d48b9f5b-4765-4e1f-b53b-f527d44e6af9 -- -ARG1 patch_manifest
