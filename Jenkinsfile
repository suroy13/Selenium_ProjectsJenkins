pipeline {
    agent any

    tools {
        maven 'Maven 3'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'Windows_LaptopSubhankar', url: 'https://github.com/suroy13/Selenium_ProjectsJenkins.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Compile') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }

            post {
                always {
                    // Collect test results even if some tests fail
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }

            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
                failure {
            
                    sh 'echo "Build and packaging Failed!"'
                }
            }
        }
    }
}