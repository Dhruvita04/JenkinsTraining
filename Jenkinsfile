pipeline {

    agent any

    tools {
        jdk 'JDK-25'
        maven 'Maven-3.9'
    }

    environment {
        DB_USERNAME = credentials('db-username')
        DB_PASSWORD = credentials('db-password')
    }

    stages {

        stage('Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Package Application') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Verify Artifact') {
            steps {
                bat 'dir target'
            }
        }

        stage('Stop Existing Application') {
            steps {
                bat '''
                @echo off

                echo Checking for application running on port 2026...

                for /f "tokens=5" %%a in ('netstat -ano ^| findstr :2026') do (
                    echo Stopping process %%a
                    taskkill /PID %%a /F
                )

                exit /b 0
                '''
            }
        }

        stage('Deploy Application') {
            steps {
                bat '''
                @echo off

                echo Starting Spring Boot Application...

                echo DB USER: %DB_USERNAME%

                start "SpringBootApp" cmd /c "java -Dspring.datasource.username=%DB_USERNAME% -Dspring.datasource.password=%DB_PASSWORD% -jar target\\jenkins-0.0.1-SNAPSHOT.jar > app.log 2>&1"

                timeout /t 30 > nul

                echo Checking application status...

                netstat -ano | findstr :2026

                echo Application Started Successfully.
                '''
            }
        }

    }

    post {

        success {
            echo 'Pipeline executed successfully.'
        }

        failure {
            echo 'Pipeline failed.'
        }

    }

}
