##Quiz test documentation

To run build the project run the following command

`` ./gradlew assemble``

then create the docker image

`` docker build . -t quiz-docker``

then run it

```docker run -p 6969:6969 --rm  quiz-docker```

that will start the service and let it working in the port 6969



