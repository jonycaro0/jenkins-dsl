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
                        credentials('git-credentials-goya')
                        url('https://github.com/jonycaro0/jenkins-dsl.git')
                    }
                }
            }

            scriptPath('jobs/choice.groovy')
        }
    }

    logRotator {
        numToKeep(5)
    }


}
