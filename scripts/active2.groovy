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

pipelineJob('PRUEBAS/dinamicList') {
    displayName('dinamicList')

    script(addParams())

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

                script """switch(true){
                case  TipoPipeline == "PIPELINE" && AmbienteOrigen == "DEV" :
                    return ${pipelinesdev}
                break;
                case  TipoPipeline == "PIPELINE" && AmbienteOrigen == "QA" :
                    return ${pipelinesdev}
                break;
                case  TipoPipeline == "PIPELINE" && AmbienteOrigen == "PRD" :
                    return ${pipelinesdev}
                break;
                case  TipoPipeline == "DATASET" && AmbienteOrigen == "DEV" :
                    return ${datasetdev}
                break;
                case  TipoPipeline == "DATASET" && AmbienteOrigen == "QA" :
                    return ${pipelinesdev}
                break;
                case  TipoPipeline == "DATASET" && AmbienteOrigen == "PRD" :
                    return ${pipelinesdev}
                break;
}
                """

                fallbackScript('"fallback choice"')
            }

            referencedParameter('TipoPipeline, AmbienteOrigen')
        }
    }
}




def addParams() {


    def hola= ['\'pipeline1\'', '\'pipeline2\''];
    println hola
    def hola2= ['\'dataset1\'', '\'dataset2\''];
    println hola2
    def hola3= ["pipeline1", "pipeline2"];
    hola3=hola3.replace('"', '"')
    println hola3
    pipelinesdev = hola
    datasetdev= hola2


}