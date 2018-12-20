<!-- Exercise for fuzzy search in groovy -->

#Installation requirements
1. Gradle 5.0
2. Groovy 2.4.12

#Commands
```
 gradle add -P userName="El nombre que desees agregar"
 gradle list 
 gradle fuzzy-search -P search="Stark"
```

#For build and run all tests 
```
 gradle build
 gradle test
```

#Algorithm for fuzzy search
### Levenshtein
[Levenshtein distance](https://en.wikipedia.org/wiki/Levenshtein_distance)

##Justify

Of all algorithms to i was view, this was a good option because util a matrix for get the minimum distance for transform a string in other

