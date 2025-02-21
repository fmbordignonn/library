pipeline {
    agent any
    stages {
        stage('Checkout branch') {
            steps {
                checkout scm: [
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false,
                    userRemoteConfigs: scm.userRemoteConfigs
                ]
            }
        }

        stage('Build') {
            steps {
                sh 'gradle clean build'
            }
        }

        stage('Test') {
            steps {
                sh 'gradle test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Fazer o deploy aqui'
            }
        }

    }

}