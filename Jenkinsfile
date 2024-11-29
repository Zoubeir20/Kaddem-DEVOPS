pipeline {
    agent any

    environment {
//         SONARQUBE_ENV = 'SonarQube'
//         SONAR_TOKEN = credentials('SonarToken')
//         DOCKER_HUB_CREDENTIALS = credentials('DockerHubCredentials')
//         IMAGE_TAG = 'v6'
//         DOCKER_IMAGE='anas_rebai_5sim4_g2_gestion_back_ski'
    }

    stages {

        stage('Checkout GIT') {

            steps {
                echo 'Pulling from Git repository...'
                git branch: 'Mazen',
                    url: 'https://github.com/Zoubeir20/Kaddem-DEVOPS.git'
            }
        }
    }


}