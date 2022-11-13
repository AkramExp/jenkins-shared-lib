#!/usr/bin/env groovy

def call() {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PWD', usernameVariable: 'USER')]) {
        sh 'docker build -t akramexp/my-repo:jma-2.0 .'
        sh "docker login -u $USER -p $PWD"
        sh 'docker push akramexp/my-repo:jma-2.0'
    }
}