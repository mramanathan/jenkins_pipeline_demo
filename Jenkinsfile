node {
    // Spit out timestamps in console log for each step in various stages
    timestamps {
        stage('Consul key/value Read') {
            checkout scm

            consulKVRead()

            dir("consul-data") {
                unstash "consul-data"
                def keyval = readFile('keyvalue.txt')
                echo " =~::~= Value fetched using consulkv global library, : ${keyval}"
            }
        }
    }
}
