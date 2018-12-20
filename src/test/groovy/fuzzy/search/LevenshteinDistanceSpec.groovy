package fuzzy.search

import spock.lang.Specification
import spock.lang.Unroll

class LevenshteinDistanceSpec extends Specification {
  
  @Unroll('get minimum distance with the next values  first=#firstValue second=#secondValue and third=#thirdValue')
  void "get minimum distance"(){
    when:
    def returnValue = LevenshteinDistance.minimumDistance(firstValue, secondValue, thirdValue)
    then:
    returnValue == expectedValue
    where:
    firstValue|secondValue|thirdValue|expectedValue
    1|2|3|1
    6|43|4|4
    5|2|14|2
  }
  
  @Unroll('get calculate distance with name=#name search_string=#toSearch')
  void "get calciulate distance"(){
    when:
    def resultValue =  LevenshteinDistance.calculateDistance(toSearch, name)
    then:
    resultValue == expectedValue
    where:
    toSearch|name|expectedValue
    'Juan'|'Juan Lopez'|6
    'Juan Lopez'|'Juan Lopez'|0
    'xixi'|'Juan Lopez'|10
  }
}
