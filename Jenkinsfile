pipeline {
  agent any

  ws {
    dir('C:/DVOPS/pipeline2') {
        stages {
      stage ('Build') {
        steps {
          echo 'Building ...'
          sh 'mvn clean install'
          }
      }
      stage ('Test') {
        steps {
          echo 'Testing ...'
          sh 'mvn test'
        }
      }
      stage ('Deploy') {
        steps {
          script {
            echo 'Deploying ...'
            deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://localhost:8090')], contextPath: '/nourish-web-project-deployment', onFailure: false, war: 'C:/DVOPS/pipeline2/target/*.war' 
            }
          }
        }
      }
    }
  }
}
