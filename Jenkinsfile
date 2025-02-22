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
                sh 'chmod +x gradlew' //teoricamente nao é aqui mas ta aqui só pra testar
                sh './gradlew clean build --refresh-dependencies'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Fazer o deploy aqui'
            }
        }

    }

}