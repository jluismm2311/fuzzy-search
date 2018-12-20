package fuzzy.search

import groovy.json.JsonOutput

public class App {

    FileService fileService = new FileService()

    def add( String person) {
        if(person!= ''){
            fileService.writeInFile(person)
            println "Usuario agregado."
        }else{
            println "Por favor agrega un usuario."
        }
        
    }

    def list() {
        def users = fileService.getFile().readLines()
        if (users.size() == 0){
            println('[]')
        }else{
            println('[')
            users.sort().eachWithIndex{ it, index ->
                println("${getUserJson(it)}${(index < users.size()-1)?',':'' }")
            }
            println(']')
        }
    }

    def fuzzy( String search) {
        def file = fileService.getFile()
        def users = file.readLines()
        def user = [text:'Sin coincidencias.', distance_difference:-1]
        users.sort().each{
            int distance = LevenshteinDistance.calculateDistance(search.toLowerCase(), it.toLowerCase())
            int distance_difference =Math.abs(it.size()-distance)
            if( distance < it.size() && distance_difference > user.distance_difference )
                user = [text:it, distance_difference:distance_difference]
        }
        println(user.distance_difference==-1?user.text:getUserJson(user.text))
    }

    def getUserJson(String user){
        JsonOutput.toJson([name: user])
    }

    static void main(String[] args) {
        if( args ) {
            if(args.length == 1)
                new App()."${args.head()}"()
            else
                new App()."${args.head()}"( args[1].toString() )
        }
    }
}
