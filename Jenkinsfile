pipeline {
    agent any
    stages {
        stage('Checkout branch') {
            steps {
                sh git branch 'master'
            }
        }

        stage('Build') {
            steps {
                sh gradle clean build
            }
        }

        stage('Test') {
            steps {
                sh gradle test
            }
        }

        stage('Deploy') {
            steps {
                echo 'Fazer o deploy aqui'
            }
        }

    }

}