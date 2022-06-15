import java.util.Arrays

import java.util.ArrayList

import groovy.transform.Field

@Field def datasetdev = []
@Field def datasetqa = []
@Field def datasetprd = []
@Field def pipelinesdev = []
@Field def pipelinesqa = []
@Field def pipelinesprd = []

folder('PRUEBAS') {
    displayName('PRUEBAS')

    description('Jobs de Pruebas')
}

pipelineJob('PRUEBAS/prueba2') {
    displayName('prueba2')

    logRotator {
        numToKeep(5)
    }

    parameters {
        addParams()

        choiceParam('TipoPipeline', ['PIPELINE', 'DATASET'], 'seleccion')

        choiceParam('AmbienteOrigen', ['DEV', 'QA', 'PRD'], 'seleccion')

        activeChoiceReactiveParam('CHOICE-1') {
            description('Allows user choose from multiple choices')

            filterable()

            choiceType('SINGLE_SELECT')

            groovyScript {
                //script """if(TipoPipeline == "PIPELINE" && AmbienteOrigen == "DEV") {return ${pipelinesdev}}else if(TipoPipeline == "PIPELINE" && AmbienteOrigen == "QA") {return ${pipelinesqa}} else if(TipoPipeline == "PIPELINE" && AmbienteOrigen == "PRD") {return ${pipelinesprd}} elseif(TipoPipeline == "PIPELINE" && AmbienteOrigen == "DEV") {return ${pipelinesdev}} """

                script """
                switch(true){
                case  TipoPipeline == "PIPELINE" && AmbienteOrigen == "DEV" :
                {return ${pipelinesdev}}
                break;
                case  TipoPipeline == "PIPELINE" && AmbienteOrigen == "QA" :
                {return ${pipelinesqa}}
                break;
                case  TipoPipeline == "PIPELINE" && AmbienteOrigen == "PRD" :
                {return ${pipelinesprd}}
                break;
                case  TipoPipeline == "DATASET" && AmbienteOrigen == "DEV" :
                {return ${datasetdev}}
                break;
                case  TipoPipeline == "DATASET" && AmbienteOrigen == "QA" :
                {return ${datasetqa}}
                break;
                case  TipoPipeline == "DATASET" && AmbienteOrigen == "PRD" :
                {return ${datasetprd}}
                break;
                default:
                print "error"

                }
                """

                fallbackScript('"fallback choice"')
            }

            referencedParameter('TIPO')
        }
    }
}

def addParams() {
    def hola= ["pipeline1", "pipeline2"];
    pipelinesdev = hola

    list1.add('2')

    list1.add('3')

    list2.add('\'a\'')

    list2.add('\'b\'')

    list2.add('\'c\'')
}
