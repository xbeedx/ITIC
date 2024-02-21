pipeline {
    agent any
    tools {
        maven 'Maven 3.9.5'
    } 
    stages {
        stage('Checkout Codebase') {
            steps {
               checkout([$class: 'GitSCM', branches: [[name: '*/sprint1']], userRemoteConfigs: [[credentialsId: '(gitlab-ssh-key)', url: 'git@gitlab.pedago.ensiie.fr:boujamaa.atrmouh/fisa_itic_23_24.git']]])
            }
        }
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            } 
        }
        stage('Build') {
            steps {
                sh 'cd Code ; mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'cd Code ; mvn test'
            }
        }
    } 
}