package fuzzy.search

class LevenshteinDistance{

  static int minimumDistance(int a, int b, int c){
    Math.min(a, Math.min(b,c))
  }

  static int calculateDistance(String toSearch, String name){
    int [][]distance = new int[toSearch.size()+1][name.size()+1]

    for (int i=0;i<=toSearch.size();i++){
      distance[i][0]=i;
    }

    for (int j=0;j<=name.size();j++){
      distance[0][j]=j;
    }

    for(int i=1;i<=toSearch.size();i++){
      for(int j=1;j<=name.size();j++){
        distance[i][j]= minimumDistance(distance[i-1][j]+1,
          distance[i][j-1]+1,
          distance[i-1][j-1]+
          ((toSearch[i-1]==name[j-1])?0:1))
      }
    }

    distance[toSearch.size()][name.size()]
  }

}
