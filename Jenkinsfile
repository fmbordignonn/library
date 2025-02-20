pipeline {
    agent any
    stages {
        stage {
            steps('Checkout branch') {
                git branch 'master'
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