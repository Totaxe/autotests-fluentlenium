pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        timeout(time: 1, unit: 'HOURS')
        disableConcurrentBuilds()
        timestamps()
    }

    parameters {
        choice choices: ['selenoid', 'browserless'], name: 'capabilities'
        string defaultValue: 'http://192.168.0.157:4444/wd/hub', name: 'remoteUrl'
    }

    stages {
        stage('Run tests') {
            steps {
                sh 'chmod a+x gradlew'
                sh "./gradlew cleanTest test --info --stacktrace \
                    -Dfluentlenium.webDriver=remote \
                    -Dfluentlenium.capabilities=${params.capabilities} \
                    -Dfluentlenium.remoteUrl=${params.remoteUrl}"
            }

            post {
                always {
                    junit keepLongStdio: true,
                        testDataPublishers: [attachments()],
                        testResults: 'build/test-results/test/*.xml'
                }
            }
        }
    }
}
