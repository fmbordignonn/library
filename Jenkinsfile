pipeline {
    agent any
    stages {
        stage {
            steps('Checkout branch') {
                git 'https://github.com/fmbordignonn/library.git'
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