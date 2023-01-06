pipeline {
    agent { dockerfile true }
    stages {
        stage('Test') {
            steps {
                sh 'set -e'
                sh 'mvn test'
            }
        }
    }
}