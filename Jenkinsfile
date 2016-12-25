// Simple build wrapper using "Declarative syntax"
pipeline {
  agent label:'linux'
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
  }   
}
