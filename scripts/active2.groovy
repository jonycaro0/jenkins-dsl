import java.util.Arrays;

import java.util.ArrayList;

import groovy.transform.Field



@Field def list1=[]

@Field def list2=[]

folder('PRUEBAS'){

    displayName('PRUEBAS')

    description('Jobs de Pruebas')

}





pipelineJob('PRUEBAS/prueba2'){

    displayName('prueba2')




    logRotator{

        numToKeep(5)

    }

    parameters {

        addList()

        choiceParam('TIPO', ['PIPELINE', 'DATASET'], 'seleccion')

       

        activeChoiceReactiveParam('CHOICE-1') {

            description('Allows user choose from multiple choices')

            filterable()

            choiceType('SINGLE_SELECT')

            groovyScript {



                script """if(TIPO == "PIPELINE") {return ${list1}}else if(TIPO == "DATASET") {return ${list2}} """

                               

                fallbackScript('"fallback choice"')

            }

            referencedParameter('TIPO')

        }

       

       

         

       

    }

   

}

def addList(){

    list1.add('1')

    list1.add('2')

    list1.add('3')

    list2.add('\'a\'')

    list2.add('\'b\'')

    list2.add('\'c\'')

}