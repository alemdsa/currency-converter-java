pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/alemdsa/currency-converter-java.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def image = docker.build("currency-converter")
                }
            }
        }

        stage('Run (Staging)') {
            steps {
                echo 'Simulating deployment to staging...'
            }
        }
    }
}