pipeline {
    agent any

    parameters {
        choice (name:'DEPLOY_ENV',choices:['int','stage','prod'],description:'Target environment')
    }
    stages {
        stage('Build') {
            agent {
                    docker { image 'foureverhh/group-alm:alm' }
            }
            steps {
                echo 'Building..'
                sh 'mvn clean install'
            }
            post{
                //always{
                //echo 'Saving artifacts..'
                //archiveArtifacts artifacts: 'target/*.war', onlyIfSuccessful: true
                //}
                always {
                    junit 'target/surefire-reports/*.xml'

                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/surefire-reports/',
                        reportFiles: 'index.html',
                        reportName: 'Unit tests',
                        reportTitles: 'Unit tests'
                        ])

                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/site/jacoco/',
                        reportFiles: 'index.html',
                        reportName: 'Tests Coverage',
                        reportTitles: 'Tests Coverage'
                    ])
                }

                success {
                    archive 'target/alm-jsf-1.0-SNAPSHOT.war'
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
