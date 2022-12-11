pipeline{
    agent any
    tools{
        maven 'local_maven'
    }
    stages{
        stage ('Build'){
            steps{
                bat 'mvn clean package'
            }
            post{
                success{
                    echo "Archiving the Artifacts"
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
        stage ('Deploy to tomcat server') {
            steps{
                echo "This is running"
                deploy adapters: [tomcat9(path: '', url: 'http://localhost:8085/')], contextPath: null, war: '**/*.war'
            }
        }
    }
}