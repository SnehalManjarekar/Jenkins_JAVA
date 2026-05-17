pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/SnehalManjarekar/Jenkins_JAVA.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
    }
}