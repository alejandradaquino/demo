##Quiz test documentation

To run build the project run the following command

`` ./gradlew assemble``

then create the docker image

`` docker build . -t quiz-docker``

then run it

```docker run -p 6969:6969 --rm  quiz-docker```

that will start the service and let it working in the port 6969

You can test the service by the following urls:

``` 

http://localhost:6969/character/{characterName}/starships
 
http://localhost:6969/planet/{planetName}/inhabitants
 
``` 

The following are examples:

http://localhost:6969/character/Arvel%20Crynyd/starships
http://localhost:6969/planet/Tatooine/inhabitants


