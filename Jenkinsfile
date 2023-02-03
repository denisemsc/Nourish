pipeline {
  agent {
    node {
            label 'maven'
        }
         ws("C:/DVOPS/pipeline2/${env.JOB_NAME}") // ws (workspace)
  }    
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
