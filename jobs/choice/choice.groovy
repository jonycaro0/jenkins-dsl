
import groovy.transform.Field
import groovy.json.JsonSlurper
import java.io.IOException
import java.util.Arrays
import java.util.ArrayList
import java.util.Collections
import java.util.Iterator
import java.util.List

//mapProject.get('nps-timer-reintentos-java').repo
//varibles logica Ambiente PT

@Field def pruebaScript

    podTemplate(containers: [
    containerTemplate(name: 'azure-cli', image: 'maikol555/azurecli', command: 'sleep', args: '99d')
   // containerTemplate(name: 'clone-git', image: 'bitnami/git', command: 'sleep', args: '99d')

  ]) {
        
       properties([parameters([[$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT', filterLength: 1, filterable: true, name: 'prueba', randomName: 'choice-parameter-29500453461600', referencedParameters: '', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: ''], script: [classpath: [], sandbox: false, script: array() ]]]])])
        def err = null



        try {
            container('azure-cli') {
               
               stage('prueba'){
                sh "func"
                sh "az"
                sh "mvn -v"
                println "lo seleccionado: "+params.parameter
               } 
            

                //obtener los parametros de la apliacion dependiendo el ambiente

            }
        }

        catch (caughtError) {
            err = caughtError

            currentBuild.result = 'FAILURE'
        }

        finally {
                //notifyBuild(currentBuild.result)

            cleanWs()

            if (err) {
                throw err
            }
        }
  }




String array(){

    String variable="[\'pepe1\',\'pep2\']"
   String pruebaScript="""
    def array=${variable}
    return array
    """ 
    return pruebaScript
}
