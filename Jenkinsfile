pipeline {
  agent any
  environment {
    registry = "aimnissley/swe645"
    registryCredential = 'dockerhub'
    backendImage = ''
  }
  stages {
    stage("Building the Backend Image") {
          steps {
            script {
              checkout scm
              sh 'rm -rf *.war'
              sh 'jar -cvf Backend.war *'
              backendImage = docker.build("aimnissley/swe645:B-$BUILD_NUMBER", "Backend")
            }
          }
    }
    stage("Pushing Images to DockerHub") {
      steps {
        script {
          docker.withRegistry( '', registryCredential ) {
            backendImage.push()
          }
        }
      }
    }
    stage("Deploying to Rancher") {
      steps {
        sh 'kubectl set image deployment/backend swe645=aimnissley/swe645:B-${BUILD_NUMBER} --kubeconfig /home/Jenkins/.kube/config'
      }
    }
  }
}
