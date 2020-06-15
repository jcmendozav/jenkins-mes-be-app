pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    echo "projectDir = MESBEService"

                '''
            }
        }

        stage('Pull from git') {
            steps {
                checkout scm

                sh 'echo $(pwd)'
                dir("${env.WORKSPACE}/MESBEService") {
                    sh 'echo $(pwd)'
                }
                sh 'echo $(pwd)'
            }
        }

        stage('Build') {
            steps {
                //sh 'cd $projectDir'
                dir("${env.WORKSPACE}/MESBEService") {
                    sh 'echo $(pwd)'

                    sh 'mvn clean package -DskipTests '
                }
            }
        }

        stage('Do docker compose') {
            steps {
                //sh 'cd $projectDir'
                dir("${env.WORKSPACE}/MESBEService") {
                     sh 'docker-compose up --build -d '

                }
            }
        }
    }
}
