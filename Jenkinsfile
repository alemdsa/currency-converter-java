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
                script {
                    docker.image('maven:3.8.7-openjdk-17').inside('-v /root/.m2:/root/.m2') {
                        sh 'mvn clean install'
                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("currency-converter")
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
