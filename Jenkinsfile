pipeline {
    agent any

    environment {
        IMAGE_NAME = "fmbordignonn/library"
        DOCKER_HUB_CREDENTIALS = "DOCKER_HUB_CREDENTIALS";
    }

    stages {
        stage('Capture version from build.gradle file') {
            steps {
                script {
                    def versionOutput = sh(script: "grep '^version' build.gradle | awk '{print \$3}' | tr -d \"'\"", returnStdout: true).trim()
                    env.IMAGE_TAG = versionOutput
                    echo '$IMAGE_TAG'
                }
            }
        }

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

        stage('Build docker image') {
            steps {
                sh 'docker build --no-cache -t $IMAGE_NAME:IMAGE_TAG .'
            }
        }

        stage('Docker hub login') {
            steps {
                withCredentials([
                    usernamePassword (
                        credentialsId: DOCKER_HUB_CREDENTIALS,
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS' )]) {
                            //é passado o DOCKER_PASS via echo por motivos de segurança, pra evitar que a senha fique armazenada no histórico de comandos do shell
                            sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                        }
            }
        }

        stage('Push docker image') {
            steps {
                sh 'docker push $IMAGE_NAME:$IMAGE_TAG'
            }
        }


        stage('Deploy') {
            steps {
                echo 'Fazer o deploy aqui'
            }
        }
    }

    post {
        success {
            echo 'Pipeline buildou'
        }
        failure {
            echo 'Vish pipeline falhou'
        }
    }
}