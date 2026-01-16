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
        stage('Clean up workspace') {
            steps {
                sh '''
                    echo "Cleaning up workspace..."

                    # Kill all Chrome & ChromeDriver (avoid zombie processes)
                    pkill -f chrome || true
                    pkill -f chromedriver || true

                    # Clean temp & report folders
                    rm -rf report/*html || true
                    rm -rf target/screenshots || true
                    rm -rf target/videos || true

                    # Clean Maven cache (optional)
                    # rm -rf ~/.m2/repository || true

                    echo "Cleanup completed."
                '''
            }
        }


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
      publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, icon: '', keepAll: false, reportDir: 'report', reportFiles: '*.html', reportName: 'Extent Report', reportTitles: '', useWrapperFileDirectly: true])
    }

    success {
      echo 'Pipeline SUCCESS 🎉'
    }

    failure {
      echo 'Pipeline FAILED ❌'
    }
  }
}
