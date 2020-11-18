pipeline {
  agent any
  environment {
    registry = "aimnissley/swe645"
    registryCredential = 'dockerhub'
    frontendImage = ''
    backendImage = ''
  }
  stages {
    stage("Building the Backend Image") {
          steps {
            script {
              checkout scm
              sh 'rm -rf *.war'
              sh 'jar -cvf Backend/Backend.war Backend/content/*'
              backendImage = docker.build("aimnissley/swe645:B-$BUILD_NUMBER", "Backend")
            }
          }
        }
    stage("Building the Frontend Image") {
      steps {
        script {
          frontendImage = docker.build("aimnissley/swe645:F-$BUILD_NUMBER", "Frontend")
        }
      }
    }
    stage("Pushing Images to DockerHub") {
      steps {
        script {
          docker.withRegistry( '', registryCredential ) {
            backendImage.push()
            frontendImage.push()
          }
        }
      }
    }
    stage("Deploying to Rancher") {
      steps {
        sh 'kubectl set image deployment/backend swe645=aimnissley/swe645:B-${BUILD_NUMBER} --kubeconfig /home/Jenkins/.kube/config'
        sh 'kubectl set image deployment/swe645 swe645=aimnissley/swe645:F-${BUILD_NUMBER} --kubeconfig /home/Jenkins/.kube/config'
      }
    }
  }
}
