#!/usr/bin/groovy

properties([
  disableConcurrentBuilds(),
  parameters([
    string(name: 'aws_vpc_id',  defaultValue: 'vpc-5c924438',    description: ''),
    string(name: 'subnet_id',   defaultValue: 'subnet-37e31041', description: ''),
    string(name: 'region',      defaultValue: 'us-west-2',       description: ''),
    string(name: 'source_ami',  defaultValue: 'ami-baa236c2',    description: ''),
  ])
])

// EC2 slaves act as Jenkins build agents and we choose one with label, 'baseami'
node {

        stage('cloneme') {
            deleteDir()

            dir('packer') {
                    sh 'git clone --branch ecs-docker-build https://github.com/mramanathan/jenkins_pipeline_demo.git'
                }
            }


        stage('Provision Packer') {
            dir('packer_tool') {
                sh 'rm -f packer_0.12.3_linux_amd64.zip'
                echo "~>Downloading packer..."
                sh 'wget -nv "https://releases.hashicorp.com/packer/0.12.3/packer_0.12.3_linux_amd64.zip"'
                // validate checksum
                sh 'sha256sum packer_0.12.3_linux_amd64.zip | grep d11c7ff78f546abaced4fcc7828f59ba1346e88276326d234b7afed32c9578fe'
                // binary shall be in <WORKSPACE_DIR>/packer_tool/
                sh 'gunzip < packer_0.12.3_linux_amd64.zip > packer'
                sh 'chmod 755 packer'

                echo "~>Validating packer installation..."
                env.packerdir = "${pwd()}"
                echo "~>packer tool installed in, ${packerdir}"
                sh "${packerdir}/packer version"
            }
        }


        stage('Generate Base AMI') {

            println "~>AWS parameters passed to packer build : "
            echo "~>AWS VPC: ${params.aws_vpc_id}, AWS Subnet: ${params.subnet_id}, AWS Region: ${params.region}, Source AMI: ${params.source_ami}"

            // Abosule path is must for packer build
            def jsonfile = "${WORKSPACE}/packer/jenkins_pipeline_demo/builder/template.json"

            def packercmd = "${packerdir}/packer build -var aws_vpc_id=${params.aws_vpc_id} -var subnet_id=${params.subnet_id} -var region=${params.region} -var source_ami=${params.source_ami} -machine-readable -force \"${jsonfile}\" "
            echo "~>+++++=======++++++"
            echo "~>Executing packer cmd: ${packercmd}"
            sh "cd ${WORKSPACE}/packer/ && ${packercmd}"
            echo "~>+++++=======++++++"
        }
}
