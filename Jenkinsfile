pipeline {
  agent any
  tools {
    maven 'maven-3.8.6'
  }
  stages {
    stage ('Build') {
      steps {
        sh 'mvn clean install' // clean and install
      }
      }
    }
    stage ('Deploy') {
      steps {
        script {
          deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://localhost:8090')], contextPath: '/nourish-web-project-deployment', onFailure: false, war: '**/*.war' 
        }
      }
    }
}
