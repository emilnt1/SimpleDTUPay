pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                sh '''
                    set -e
                    mvn test
                '''
            }
        }
        stage('Build Docker Compose'){
            steps {
                sh '''
                    set -e
                    docker-compose build
                '''
            }
        }
        stage('Run Docker Compose'){
            steps {
                sh '''
                    set -e
                    docker-compose up -d
                '''
            }
        }
    }
}