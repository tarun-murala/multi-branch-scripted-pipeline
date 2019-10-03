// Declarative Scripted Pipeline
pipeline {
    agent any
    tools { 
        maven 'Maven' 
    }
    stages {
        stage('Checkout') {
            steps {
                snDevOpsStep()
                snDevOpsChange()
                checkout scm
            }
        }

        stage('Build') {
            stages {
                stage("Compile") {
                    steps {
                        snDevOpsStep()
                        snDevOpsChange()
                        sh "mvn clean install -DskipTests=true"
                    }
                }
                stage("Generate-JavaDoc") {
                    stages {
                        stage("Build-Generate-JavaDoc-HTML") {
                            steps {
                                snDevOpsStep()
                                snDevOpsChange()
                                sh "mvn javadoc:javadoc"
                            }
                        }
                        stage("Generate-JavaDoc-JAR") {
                            steps {
                                snDevOpsStep()
                                snDevOpsChange()
                                sh "mvn javadoc:jar"
                            }
                        }
                    }
                }
            }
        }

        stage('Test') {
            parallel {
                stage("Run Test") {
                    steps {
                        snDevOpsStep()
                        snDevOpsChange()
                        sh "mvn test"
                    }
                    post {
                        always {
                            junit "**/TEST-*.xml"
                        }
                    }
                }
                stage("Generate-JavaDoc") {
                    steps {
                        snDevOpsStep()
                        snDevOpsChange()
                        sh "mvn javadoc:test-jar"
                    }
                }
            }
        }

        stage('Deploy') {
            stages {
                stage('Deploy-Dev') {
                    when {
                        branch 'dev'
                    }
                    steps {
                        snDevOpsStep()
                        snDevOpsChange()
                        // sh "mvn -B deploy"
                        // sh "mvn -B release:prepare"
                        // sh "mvn -B release:perform"
                        echo "Deploy - Dev"
                    }
                }
                stage('Deploy-Master') {
                    when {
                        branch 'master'
                    }
                    steps {
                        snDevOpsStep()
                        snDevOpsChange()
                        // sh "mvn -B deploy"
                        // sh "mvn -B release:prepare"
                        // sh "mvn -B release:perform"
                        echo "Deploy - Master"
                    }
                }
            }
        }
    }
}