package fuzzy.search

import spock.lang.Specification
import spock.lang.Shared

class FileServiceSpec extends Specification {
    @Shared
    String fileName = '/tmp/test-search.txt'
    FileService service

    void setup(){
      service = new FileService()
      service.fileName = fileName
    }

    void cleanupSpec(){
      File file = new File(fileName)
      if(file.exists()){
        file.delete()
      }
    }

    void "get file"(){
      when:
      def result = service.getFile()
      then:
      result
    }

    void "write in file"(){
      given:
      String name = "Juan Lopez"
      when:
      def result = service.writeInFile(name)
      then:
      result
      result.readLines()[0] ==name
    }

}
