pipeline {
    agent any
    parameters {
        choice (name:'DEPLOY_ENV',choices:['int','stage','prod'],description:'Target environment')
    }
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean package'
            }
            post{
                always{
                echo 'Saving artifacts..'
                archiveArtifacts artifacts: 'target/*.war', onlyIfSuccessful: true
                }
            }
        }

        stage ('Deploy') {
            agent any
            steps{
                echo 'Deploying ......'
                sh 'asadmin --port 4848 deploy --force --name alm-jsf-${DEPLOY_ENV} --contextroot alm-jsf--${DEPLOY_ENV} --properties enable-implicit-cdi=false target/alm-jsf-1.0-SNAPSHOT.war'
            }
        }
    }
}
