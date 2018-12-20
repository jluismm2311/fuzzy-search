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

}
