/*
 * This Spock specification was generated by the Gradle 'init' task.
 */
package fuzzy.search

import spock.lang.Specification
import spock.lang.Unroll

class AppTest extends Specification {

    App app
    FileService fileService

    void setup(){
        fileService = new FileServiceToTest()
        app =  new App() 
        app.fileService = fileService
    } 

    @Unroll
    def "get field value with empty body"(){
        when:
        app.getField('',fieldName, bodyFormat)
        then:
        def ex = thrown(Exception)
        ex.message == "La petición necesita un json de la siguiente forma $bodyFormat"
        where:
        bodyFormat|fieldName
        '{"testKey":"testValue"}'|'test'
        '{"name":"juan"}'|'name'
        '{"search":"juan"}'|'search'
    }

    @Unroll
    def "get field value without key in body"(){
        when:
        app.getField(bodyFormat,fieldName, bodyFormat)
        then:
        def ex = thrown(Exception)
        ex.message == "El json de la petición debe contener el campo $fieldName"
        where:
        bodyFormat|fieldName
        '{"testKey":"testValue"}'|'search'
        '{"name":"juan"}'|'test'
        '{"search":"juan"}'|'name'
    }

    @Unroll
    def "get field return value"(){
        when:
        def result = app.getField(bodyFormat,fieldName, bodyFormat)
        then:
        result == expectedValue
        where:
        bodyFormat|fieldName|expectedValue
        '{"testKey":"testValue"}'|'testKey'|'testValue'
        '{"name":"juan"}'|'name'|'juan'
        '{"search":"juan"}'|'search'|'juan'
    }

    def "list user to list is empty"() {
        when:
        def buffer = new ByteArrayOutputStream()
        System.out = new PrintStream(buffer)
        and:
        app.list()
        then:
        buffer.toString() == '[]\n'
        notThrown(Exception)
    }

    def "add user"() {
        when:
        def buffer = new ByteArrayOutputStream()
        System.out = new PrintStream(buffer)
        and:
        app.add('{"name":"testValue"}')
        then:
        buffer.toString() == 'Usuario agregado.\n'
        notThrown(Exception)
    }

    def "search without coincidences"() {
        when:
        def buffer = new ByteArrayOutputStream()
        System.out = new PrintStream(buffer)
        and:
        app.fuzzy('{"search":"testValue"}')
        then:
        buffer.toString() == 'Sin coincidencias.\n'
        notThrown(Exception)
    }
}
