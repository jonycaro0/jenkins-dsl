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
        
       //properties([parameters([[$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT', filterLength: 1, filterable: true, name: 'prueba', randomName: 'choice-parameter-29500453461600', referencedParameters: '', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: ''], script: [classpath: [], sandbox: true, script: array() ]]]])])
       properties([parameters([[$class: 'ChoiceParameter', choiceType: 'PT_SINGLE_SELECT', filterLength: 1, filterable: false, name: 'tipoPipeline', randomName: 'choice-parameter-83882233331100', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], oldScript: '', sandbox: false, script: '["error"]'], script: [classpath: [], oldScript: '', sandbox: false, script: '["pipeline", "dataset"]']]], [$class: 'ChoiceParameter', choiceType: 'PT_SINGLE_SELECT', filterLength: 1, filterable: false, name: 'ambienteOrigen', randomName: 'choice-parameter-83882244519900', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], oldScript: '', sandbox: false, script: ''], script: [classpath: [], oldScript: '', sandbox: false, script: '["dev", "qa"]']]],[$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT', filterLength: 1, filterable: true, name: 'prueba', randomName: 'choice-parameter-29500453461600', referencedParameters: 'tipoPipeline, ambienteOrigen', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: ''], script: [classpath: [], sandbox: true, script:"if(${params.tipoPipeline}.equals('pipeline')){ return ${pepe()}}else if(params.tipoPipeline.equals('dataset')){ return ${pepa()}}" ]]]])])
        def err = null

    node(POD_LABEL) {
        
        try {
            pepe()
            pepa()
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

  }


String pepe(){

    String variable="[\'pepe1\',\'pepa2\']"
  print variable
   String pruebaScript="""
    def array=${variable}
    return array
    """ 
    return variable
}

String pepa(){

    String variable="[\'pepa1\',\'pepa2\']"
  print variable
   String pruebaScript="""
    def array=${variable}
    return array
    """ 
    return pruebaScript
}
