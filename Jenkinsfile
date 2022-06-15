node (){


    gitCheckout('feature/seedJob', 'git-credentials-goya', 'https://github.com/jonycaro0/jenkins-dsl.git')

  stage('Create Jobs'){
  
  loadDsl('scripts')
  
  
  }
  }
  
  def gitCheckout(branch, credentials, repo) {
    checkout([$class: 'GitSCM', branches: [[name: branch ]], extensions: [], userRemoteConfigs: [[credentialsId: credentials, url: repo]]])
}

  def loadDsl(folder){
  
  jobDsl targets: "${folder}/activechoice.groovy"

  }

