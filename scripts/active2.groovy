folder('choice') {
    displayName('choice')
    description('choice')
}

pipelineJob('choice/choice2') {
    displayName('choice2')

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

            scriptPath('jobs/choice/choice2.groovy')
        }
    }

    logRotator {
        numToKeep(5)
    }


}
