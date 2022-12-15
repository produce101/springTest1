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
                sh 'echo testtest wowwowwowowow!!!333 이부분 한글 나오는지 확인해봅니다~'
                //sh 'pwd'
                //git branch: 'development',
                //    credentialsId: 'zxczzxc',
                //    url: 'https://github.com/produce101/springTest1.git'
            }
        }

    }

}