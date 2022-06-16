folder('choice') {
    displayName('choice')
    description('choice')
}

pipelineJob('choice/choice') {
    displayName('choice')

    definition {
        cpsScm {
            scm {
                git {
                    branch('feature/seedJob')
                    remote {
                        url('https://github.com/jonycaro0/jenkins-dsl.git')
                    }
                }
            }

            scriptPath('jobs/choice/choice.groovy')
        }
    }

    logRotator {
        numToKeep(5)
    }

     parameters {

        
        choiceParam('tipoPipeline', ['pipeline', 'dataset'], 'seleccion')

        choiceParam('ambienteOrigen', ['DEV', 'QA', 'PRD'], 'seleccion')
     }


}
