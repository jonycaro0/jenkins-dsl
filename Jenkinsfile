node {

  stage('Create Jobs'){
  
  loadDsl('scripts')
  
  cleanWs()
  
  }
  }

  def loadDsl(folder){
  jobDsl targets: "${folder}/"

  }

