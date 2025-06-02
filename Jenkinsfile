pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/alemdsa/currency-converter-java.git'
            }
        }

        stage('Build & Test') {
            agent {
                docker {
                    image 'maven:3.8.7-openjdk-17'
                    args '-v /root/.m2:/root/.m2'
                }
            }
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
