package fuzzy.search

class FileService {

  static String fileName = 'fuzzy-search.txt'

  def getFile(){
    File file = new File(fileName)
    if(!file.exists())
      file.createNewFile()
    file  
  }

  def writeInFile(String newLine){
    if(newLine == null)
      return
    File file=getFile()
    file << "${newLine}\n"
    file
  }

}
