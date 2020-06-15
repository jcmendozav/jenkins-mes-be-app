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
        stage('Publish to dockerhub') {
            steps {
                dir("${env.WORKSPACE}/MESBEService") {
                    //sh 'cd $projectDir'
                    sh 'echo $(pwd)'

                    script {
                        docker.withRegistry('https://registry.hub.docker.com', 'mowa_docker_hub') {
                            def appDockerfile = 'app.Dockerfile'

                            def customImage =  docker.build('soportemowa/mes_be_service', "-f ${appDockerfile} .")

            /* Push the container to the custom Registry */
                            customImage.push()
                        }
                    }
                }
            }
        }
    }
}
