pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/YOUR_GITHUB_USERNAME/YOUR_REPO.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}