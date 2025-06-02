pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/alemdsa/currency-converter-java.git'
            }
        }

        stage('Build & Test') {
            steps {
                docker.image('maven:3.8.7-openjdk-17').inside {
                    sh 'mvn clean install'
                }
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
