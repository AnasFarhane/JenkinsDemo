pipeline{
    agent any
    tools{
        maven 'local_maven'
    }
    stages{
        stage ('Build'){
            steps{
                echo "Here"
                sh 'mvn clean package'
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
                script{
                    readProp = readProperties file: 'build.properties'
                }
                echo "This is running on ${readProp['deploy.type']}"
                deploy adapters: [tomcat10(path: '', url: 'http://localhost:8081/')], contextPath: null, war: '**/*.war'
            }
        }
    }
}