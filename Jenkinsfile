  pipeline {
    agent any

    tools {
    maven 'Maven_3.9'
    jdk 'JDK_21'
    }

    environment {
    MAVEN_OPTS = '-Xmx1024m'
    }

    stages {
    
    stage('Checkout') {
    steps {
    checkout scm
    }
    }
    
    stage('Build & Run Tests') {
    steps {
    sh '''
    mvn clean test
    '''
    }
    }
    
    stage('Rerun Failed Tests') {
    when {
    expression {
    return fileExists('target/rerun.txt') &&
  sh(script: "test -s target/rerun.txt", returnStatus: true) == 0
  }
  }
    steps {
    sh '''
    echo "Rerunning failed scenarios..."
    mvn test -Dtest=runners.TestRerunFailCaseRunner -Drerun=true
    '''
            }
        }
    }

    post {

        always {
            echo 'Archiving test artifacts...'

  archiveArtifacts artifacts: '''
                report/*.html,
            ''', fingerprint: true
  }

    success {
    echo 'Pipeline SUCCESS 🎉'
  }

    failure {
    echo 'Pipeline FAILED ❌'
  }
  }
  }
