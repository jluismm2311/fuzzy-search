package fuzzy.search

class FileService {

  static String fileName = 'fuzzy-search.txt'

  def getFile(){
    file = new File(filename)
    if(!file.exists())
      file.createNewFile()
    file  
  }

  def writeInFile(String newLine){
    file=getFile()
    file << "${newLine}\n"
  }

}
