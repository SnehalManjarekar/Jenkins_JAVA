pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/SnehalManjarekar/GrowAI_Cucumber_Selenium_Project.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
    }
}