// Jenkins Pipeline for Maven Project
node {
    stage('Checkout Source') {
        // Checkout code from SCM
        checkout scm
    }

    stage('SonarQube Analysis') {
        // Set up Maven tool
        def mvn = tool 'Default Maven'
        // Run SonarQube analysis
        withSonarQubeEnv() {
            sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=maven-project"
        }
    }
}
