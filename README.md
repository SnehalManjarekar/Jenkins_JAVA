# Continuous Integration and Delivery with Jenkins for Automated Tests

## Project Overview
This project demonstrates Continuous Integration (CI) using Jenkins to automate testing for a web application and API testing.

The pipeline automatically:
- Clones the project from GitHub
- Builds the project using Maven
- Executes Selenium WebDriver tests
- Generates and displays test reports in Jenkins

---

# Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Postman
- Jenkins
- Maven
- Git & GitHub

---

# Project Structure
 Project Folder │
├── pom.xml
├── src
│   ├── test
│   │   ├── java
│   │   │   ├── base
│   │   │   │   └── BaseClass.java
│   │   │   ├── pages
│   │   │   │   └── LoginPage.java
│   │   │   ├── runner
│   │   │   │   └── TestRunner.java
│   │   │   └── steps
│   │   │       └── LoginSteps.java
│   │   │
│   │   └── resources
│   │       └── features
│   │           └── Login Functionality.feature
│
└── target
├── Jenkinsfile
└── README.md


Selenium Test Scenarios
The Selenium automation includes the following scenarios for:
https://the-internet.herokuapp.com/login

Test Cases
Valid Login
Invalid Login
Empty Username
Empty Password


Prerequisites
Before running the project, install:
Java JDK 8 or above
Maven
Jenkins
Git
Chrome Browser
ChromeDriver


Jenkins Installation
Step 1: Install Jenkins
Download Jenkins from:
https://www.jenkins.io/download/

Step 2: Start Jenkins
Windows
java -jar jenkins.war
Open Jenkins
http://localhost:8080
Required Jenkins Plugins
Install the following plugins:
Git Plugin
Maven Integration Plugin
TestNG Plugin
Pipeline Plugin
HTML Publisher Plugin


Maven Dependencies
Add dependencies in pom.xml

Running Tests Locally
Run Selenium Tests
mvn test

Jenkins Pipeline Setup
Create Jenkins Pipeline Job
Open Jenkins Dashboard
Click New Item
Enter Project Name
Select Pipeline
Click OK

Configure GitHub Repository
In Pipeline configuration:
Select Pipeline script from SCM
SCM: Git
Enter GitHub Repository URL
Example:
https://github.com/your-username/jenkins-ci-project.git
Sample Jenkinsfile
pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/SnehalManjarekar/Jenkins_JAVA.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/surefire-reports/*.xml'
        }
    }
}

Running Jenkins Pipeline
Save Pipeline Configuration
Click Build Now
Open Build History
Check Console Output
Verify Test Reports

Test Reports
Jenkins displays:
Passed Test Cases
Failed Test Cases
Execution Time
Build Status

Reports available in:
target/surefire-reports

Author :
Snehal Manjarekar