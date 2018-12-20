package fuzzy.search

import spock.lang.Specification

class FileServiceSpec extends Specification {
    
    FileService service

    void setup(){
      service = new FileService()
    }

    void cleanup(){
      service.getFile().delete()
    }

    void "get file"(){
      when:
      def result = service.getFile()
      then:
      !result
    }

}
