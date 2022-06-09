node {

  stage('Create Jobs'){
  loadDsl('scripts')
  cleanWs()
  
  }

  loadDsl(folder){
  jobDsl targets: "${folder}/"

  }

}
