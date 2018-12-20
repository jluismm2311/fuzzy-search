package fuzzy.search

class FileServiceToTest extends FileService {


  @Override
  def getFile(){
    File.createTempFile('test','txt')
  }

  @Override
  def writeInFile(String newLine){
    if(newLine == null)
      return
    def  file=getFile()
    file << "${newLine}\n"
    file
  }

}
