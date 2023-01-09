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
    }
}