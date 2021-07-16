 using hostname.

node {

    withMaven(maven:'maven') {

        stage('Checkout') {
            git url: 'https://github.com/rhoussou/microservices.git', credentialsId: 'rhoussou', branch: 'master'
        }

        stage('Build') {
            sh 'mvn clean install'

            def pom = readMavenPom file:'pom.xml'
            print pom.version
            env.version = pom.version
        }

        stage('Image') {
            dir ('auth-server') {
                def app = docker.build "localhost:5000/auth-server:${env.version}"
                app.push()
            }
        }

        stage ('Run') {
            docker.image("localhost:5000/auth-server:${env.version}").run('-p 2222:2222 -h account --name account --link discovery')
        }

        stage ('Final') {
            build job: 'auth-server-pipeline', wait: false
        }      

    }

}