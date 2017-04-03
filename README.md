### Jenkins Pipeline

#### Script Purpose:

- Basic usage of 'parallel' step with multiple named stages, though 'stage' keyword isn't necessary.

- Howto have external function to handle generic and repeatable code.

#### NOTE:

- With Jenkins v2.40 and Jenkinsfile configured to run on 'master', stages are run as given in Jenkinsfile

- With Jenkins v2.51 and Jenkinsfile set to run on build agent (labels: linux, ubuntu), last two stages (Go build and parallel) are swapped!
