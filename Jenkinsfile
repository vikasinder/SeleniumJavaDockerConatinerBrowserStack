pipeline {
    agent any

    parameters {
        string(name: 'BROWSER', defaultValue: 'chrome', description: 'Browser to run tests on')
        string(name: 'ENVIRONMENT', defaultValue: 'QA', description: 'Environment to run tests on')
        string(name: 'EXECUTION_ENV', defaultValue: 'local', description: 'Execution environment: local / docker / browserstack')
        string(name: 'OS', defaultValue: 'windows', description: 'Operating system for Selenium Grid')
    }

    stages {

        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/vikasinder/SeleniumJavaDockerConatinerBrowserStack.git', branch: 'master'
            }
        }

        stage('Start Selenium Grid') {
            steps {
                // If using Docker, point to your docker-compose.yml location
                bat "docker-compose -f src/main/resources/docker-compose.yml up -d"
            }
        }

        stage('Run Selenium Tests') {
            steps {
                // Pass all 4 parameters as Maven system properties
                bat """
                mvn clean test \
                -Dbrowser=${params.BROWSER} \
                -DTEST_ENV_CMD_LINE=${params.ENVIRONMENT} \
                -DEXECUTION_ENV_CMD_LINE=${params.EXECUTION_ENV} \
                -DOS=${params.OS} 
                """
            }
        }

        stage('Stop Selenium Grid') {
            steps {
                bat "docker-compose -f src/main/resources/docker-compose.yml down"
            }
        }
    }

    post {
        always {
            // Archive and publish TestNG reports
            archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}