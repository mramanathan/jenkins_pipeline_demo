// Simple build wrapper using "Declarative syntax"
pipeline {
  
  agent {
    label 'linux'
  }
  
  stages {
    
    stage(" =~= Greet =~= ") {
      steps {
        echo "Hello Jenkins"
      }
    }
    
    stage(" =~= Python Version =~= ") {
      steps {
        sh "python --version"
      }
    }
    
    stage(" =~= Python Package =~= ") {
      steps {
          // without explicit call to /bin/bash, execution would fail complaining about set options used in the script.
          script {
              def pyinfo = sh (returnStdout: true, script: "/bin/bash ${env.WORKSPACE}/get_python_info.sh").trim()
              echo "python info, ${pyinfo}"              
          }
      }
    }   
  }   
}
