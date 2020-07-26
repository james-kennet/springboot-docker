# Running SpringBoot2 in Docker Container.

# SpringBoot2 Rest API features:
- H2 in-memory database. With data.
- Spring Data
- Custom Response object
- Custom Exception handling
- Junit
- slf4j MDC logging
## Package the jar
```
mvn clean package
```
### Bootstrap the application:
* In IDE

``Run PersonApplication.java main class
``
* In command-line

``
java -jar target/springboot-docker-1.jar
``
## Dockerfile
```dockerfile
FROM openjdk:8-jdk-alpine
RUN apk update && apk add bash && mkdir -p /app/springboot && mkdir /app/springboot/log
COPY ./target/springboot-docker-1.jar /app/springboot
WORKDIR /app/springboot
RUN touch log/springboot-docker.log
ENTRYPOINT ["java", "-jar", "springboot-docker-1.jar"]
```
## makefile
```makefile
docker build -t springboot-docker .
docker run -p 8082:8080 -t springboot-docker
```
### Bootstrap the application:
* In docker container

``
./makefile
``
### List all docker container:
```dockerfile
docker ps -a

CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
d1b0daff2185        springboot-docker   "java -jar springboo…"   2 minutes ago       Up 2 minutes        0.0.0.0:8082->8080/tcp   recursing_brahmagupta
```
### Access logs in docker container:
```dockerfile
docker logs --tail 500 -f [CONTAINER_ID]
```
### Access logs in docker container from the application log file:
* Access docker container in Mac OS / Linux
```dockerfile
1. docker exec -it [CONTAINER_ID] bash

Execute inside the container:        
2. tail -f 500 log/springboot-docker.log
```
* Access docker container in Windows 10 Home
```dockerfile
1. winpty docker exec -it [CONTAINER_ID] bash

Execute inside the container:        
2. tail -f 500 log/springboot-docker.log
```
#### /person/hello
``` json
curl -X GET http://localhost:8082/person/hello
Response:

Hello James, it is now 2020-07-26 09:20:02.296
```

#### /person/all  
``` json
curl -X GET http://localhost:8082/person/all
Response:

[
  {
    "id": "e0ab2cd1-7090-4c46-92dc-0ab2788db604",
    "name": "James",
    "age": 23,
    "gender": "Male"
  },
  {
    "id": "d4b6b287-88bf-4c63-befc-c3c39c523a37",
    "name": "Bond",
    "age": 25,
    "gender": "Male"
  },
  {
    "id": "4efe8afa-52b9-458c-9f76-6220e84b7203",
    "name": "Rachel",
    "age": 28,
    "gender": "Female"
  },
  {
    "id": "7cdc28fa-a445-4ac3-919a-2fdd4d327546",
    "name": "Ryan",
    "age": 30,
    "gender": "Male"
  },
  {
    "id": "adb9ccbb-aadd-4587-9f77-de68e732d09a",
    "name": "Darrel",
    "age": 31,
    "gender": "Male"
  },
  {
    "id": "c4b4dc4a-a273-4aa6-acff-4b8658aa41dc",
    "name": "Steven",
    "age": 34,
    "gender": "Male"
  },
  {
    "id": "31c45237-8def-48d8-a5f0-6897ce51b793",
    "name": "Markel",
    "age": 36,
    "gender": "Male"
  },
  {
    "id": "19925f7b-1429-4ad1-a196-7dc7ce21a2bb",
    "name": "Karlson",
    "age": 38,
    "gender": "Male"
  },
  {
    "id": "b508e79b-0cb1-4ca8-ba3c-7331c522483b",
    "name": "Cherry",
    "age": 51,
    "gender": "Female"
  },
  {
    "id": "c660184d-817a-4128-94cf-8c758ad6b376",
    "name": "Mary",
    "age": 54,
    "gender": "Female"
  },
  {
    "id": "4e246ee4-6a53-4b6c-b061-d29dc373ddc9",
    "name": "Jenny",
    "age": 55,
    "gender": "Female"
  },
  {
    "id": "dbe80c88-8e04-4ab9-a323-3cfeb3ae0595",
    "name": "Christian",
    "age": 56,
    "gender": "Male"
  },
  {
    "id": "32726124-3bac-42d8-8539-435bc0118dbe",
    "name": "Carol",
    "age": 57,
    "gender": "Female"
  }
]
```

#### /person/all/columnsort
* [sort by name] 
 ``` json
curl -X POST http://localhost:8082/person/all/columnsort -d '{"column": "name"}' -H "Content-Type: application/json"
Response:

[
    {
        "id": "d4b6b287-88bf-4c63-befc-c3c39c523a37",
        "name": "Bond",
        "age": 25,
        "gender": "Male"
    },
    {
        "id": "32726124-3bac-42d8-8539-435bc0118dbe",
        "name": "Carol",
        "age": 57,
        "gender": "Female"
    },
    {
        "id": "b508e79b-0cb1-4ca8-ba3c-7331c522483b",
        "name": "Cherry",
        "age": 51,
        "gender": "Female"
    },
    {
        "id": "dbe80c88-8e04-4ab9-a323-3cfeb3ae0595",
        "name": "Christian",
        "age": 56,
        "gender": "Male"
    },
    {
        "id": "adb9ccbb-aadd-4587-9f77-de68e732d09a",
        "name": "Darrel",
        "age": 31,
        "gender": "Male"
    },
    {
        "id": "e0ab2cd1-7090-4c46-92dc-0ab2788db604",
        "name": "James",
        "age": 23,
        "gender": "Male"
    },
    {
        "id": "4e246ee4-6a53-4b6c-b061-d29dc373ddc9",
        "name": "Jenny",
        "age": 55,
        "gender": "Female"
    },
    {
        "id": "19925f7b-1429-4ad1-a196-7dc7ce21a2bb",
        "name": "Karlson",
        "age": 38,
        "gender": "Male"
    },
    {
        "id": "31c45237-8def-48d8-a5f0-6897ce51b793",
        "name": "Markel",
        "age": 36,
        "gender": "Male"
    },
    {
        "id": "c660184d-817a-4128-94cf-8c758ad6b376",
        "name": "Mary",
        "age": 54,
        "gender": "Female"
    },
    {
        "id": "4efe8afa-52b9-458c-9f76-6220e84b7203",
        "name": "Rachel",
        "age": 28,
        "gender": "Female"
    },
    {
        "id": "7cdc28fa-a445-4ac3-919a-2fdd4d327546",
        "name": "Ryan",
        "age": 30,
        "gender": "Male"
    },
    {
        "id": "c4b4dc4a-a273-4aa6-acff-4b8658aa41dc",
        "name": "Steven",
        "age": 34,
        "gender": "Male"
    }
]
```
#### /person/all/columnsort
* [sort by age] 
 ``` json
curl -X POST http://localhost:8082/person/all/columnsort -d '{"column": "age"}' -H "Content-Type: application/json"
Response:

[
    {
        "id": "e0ab2cd1-7090-4c46-92dc-0ab2788db604",
        "name": "James",
        "age": 23,
        "gender": "Male"
    },
    {
        "id": "d4b6b287-88bf-4c63-befc-c3c39c523a37",
        "name": "Bond",
        "age": 25,
        "gender": "Male"
    },
    {
        "id": "4efe8afa-52b9-458c-9f76-6220e84b7203",
        "name": "Rachel",
        "age": 28,
        "gender": "Female"
    },
    {
        "id": "7cdc28fa-a445-4ac3-919a-2fdd4d327546",
        "name": "Ryan",
        "age": 30,
        "gender": "Male"
    },
    {
        "id": "adb9ccbb-aadd-4587-9f77-de68e732d09a",
        "name": "Darrel",
        "age": 31,
        "gender": "Male"
    },
    {
        "id": "c4b4dc4a-a273-4aa6-acff-4b8658aa41dc",
        "name": "Steven",
        "age": 34,
        "gender": "Male"
    },
    {
        "id": "31c45237-8def-48d8-a5f0-6897ce51b793",
        "name": "Markel",
        "age": 36,
        "gender": "Male"
    },
    {
        "id": "19925f7b-1429-4ad1-a196-7dc7ce21a2bb",
        "name": "Karlson",
        "age": 38,
        "gender": "Male"
    },
    {
        "id": "b508e79b-0cb1-4ca8-ba3c-7331c522483b",
        "name": "Cherry",
        "age": 51,
        "gender": "Female"
    },
    {
        "id": "c660184d-817a-4128-94cf-8c758ad6b376",
        "name": "Mary",
        "age": 54,
        "gender": "Female"
    },
    {
        "id": "4e246ee4-6a53-4b6c-b061-d29dc373ddc9",
        "name": "Jenny",
        "age": 55,
        "gender": "Female"
    },
    {
        "id": "dbe80c88-8e04-4ab9-a323-3cfeb3ae0595",
        "name": "Christian",
        "age": 56,
        "gender": "Male"
    },
    {
        "id": "32726124-3bac-42d8-8539-435bc0118dbe",
        "name": "Carol",
        "age": 57,
        "gender": "Female"
    }
]
```