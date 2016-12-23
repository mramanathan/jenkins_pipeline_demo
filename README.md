# Jenkins Pipeline

Examples to showcase usage of Jenkins pipeline integrated with Rundeck

### Pre-requisites

1. Jenkins master running v2.3x

2. Rundeck CLI : https://rundeck.github.io/rundeck-cli/
RD CLI tool must be installed in the server where Jenkins master is hosted.

3. Rundeck server / management node installed in a system different from Jenkins or RD CLI.

### Internals

Embedded within the Jenkinsfile is the shell script to trigger job in Rundeck.
Of course, the connection to Rundeck is not that secure, you know why !!!

Rundeck shell script connects to the job hosted in the Rundeck server.
Manifest file is passed as parameter to the Rundeck job.

#### Result

Jenkins job that uses this Jenkinsfile will trigger the job in the 
Rundeck server and end it's execution (without waiting for the result).

In the Rundeck instance, job should have accepted the input paramter and as 
per the job (in Rundeck) definition, necessary actions must have been initiated.
