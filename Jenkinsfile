pipeline {
  agent any
  tools {
    maven 'Maven 3.8.6' 
  }
  stages {
    stage ('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage ('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage ('Deploy') {
      steps {
        script {
          deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://localhost:8090')], contextPath: '/nourish-web-project-deployment', onFailure: false, war: 'C:/DVOPS/pipeline2/target/*.war'
        }
      }
    }
  }
}

