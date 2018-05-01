#!/usr/bin/groovy

properties([
  disableConcurrentBuilds(),
  parameters([
    string(name: 'aws_vpc_id',  defaultValue: '',    description: ''),
    string(name: 'subnet_id',   defaultValue: '', description: ''),
    string(name: 'region',      defaultValue: '',       description: ''),
    string(name: 'source_ami',  defaultValue: '',    description: '')
  ])
])

node('amibuilder') {
    timestamps {

        stage('cloneme') {
            deleteDir()

			withCredentials([string(credentialsId: 'c12d52bc-6e8d-4604-a663-7fc0cfbeadd5', variable: 'GITHUB_TOKEN')]) {
                sh 'git clone --branch amibuild https://${GITHUB_TOKEN}@github.com/mramanathan/jenkins_pipeline_demo.git'
            }

            sh 'sudo apt-get install -y python-pip && sudo -H pip install -U boto3'
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


        stage('Build AMI') {

            println "~>AWS parameters passed to packer build : "
            echo "~>AWS VPC: ${params.aws_vpc_id}, AWS Subnet: ${params.subnet_id}, AWS Region: ${params.region}, Source AMI: ${params.source_ami}"

            // Abosule path is must for packer build
            def jsonfile = "${WORKSPACE}/jenkins_pipeline_demo/builder/template.json"

            def packercmd = "${packerdir}/packer build -var aws_vpc_id=${params.aws_vpc_id} -var subnet_id=${params.subnet_id} -var region=${params.region} -var source_ami=${params.source_ami} -machine-readable -force \"${jsonfile}\" "
            echo "~>+++++=======++++++"
            echo "~>Executing packer cmd: ${packercmd}"
            sh "cd ${WORKSPACE}/packer/ && ${packercmd}"
            echo "~>+++++=======++++++"
        }
    }
}
