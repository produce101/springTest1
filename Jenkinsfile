pipeline {
    agent {
        label 'tomcat_slave'
    }
    
    tools {
        maven 'maven381' // 빌드시 사용 할 maven
    }
    
    stages {
        

       stage('Checkout') {
            steps {
                sh 'echo testtest!!!'
                //sh 'pwd'
                //git branch: 'development',
                //    credentialsId: 'zxczzxc',
                //    url: 'https://github.com/produce101/springTest1.git'
            }
        }

    }

}