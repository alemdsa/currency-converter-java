pipeline {
    agent any

    environment {
        APP_NAME = 'currency-converter'
        JAR_NAME = 'currency-converter-1.0.0.jar'
        DOCKER_IMAGE = "myrepo/${APP_NAME}:latest"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/alemdsa/currency-converter-java'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}", ".")
                }
            }
        }

        stage('Run (Staging)') {
            steps {
                sh 'docker run -d -p 8080:8080 --name currency-converter-container ${DOCKER_IMAGE}'
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
            sh 'docker rm -f currency-converter-container || true'
        }
        failure {
            echo 'Build failed!'
        }
        success {
            echo 'Build succeeded!'
        }
    }
}
