node {

  stage('Create Jobs'){
  
  loadDsl('scripts')
  
  cleanWs()
  
  }
  }

  def loadDsl(folder){
  
  sh "ls"
  sh "pwd"
  jobDsl targets: "${folder}/activechoice.groovy"

  }

