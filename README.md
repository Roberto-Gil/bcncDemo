# RestFul Brand DEMO 

## Overview
This microservice contains the code corresponding to the BCNC test demo

## Guidelines
Run microservice:

1. Install maven from https://maven.apache.org/download.cgi and configure

2. Execute mvn clean install to generate demo-0.0.1-SNAPSHOT.jar

3. Exceute java -jar path.../demo-0.0.1-SNAPSHOT.jar

## H2 and JPA configuration

1. Datasource:
   
    It´s important add  url: ....;TIME ZONE=UTC in order to manage DATE fields in UTC
```yml
  datasource:
    url: jdbc:h2:mem:mydb;TIME ZONE=UTC
    username: demoUser
    password: demoPassword
    driverClassName: org.h2.Driver
    initialization-mode: always
```
2. Jpa:
   
    ddl-auto: none is added in order to load DB with 2 scripts:
   
        - schema.sql
        - data.sql

3. H2 Console    

Access by http://localhost:8080/demo/h2-console/

```yml
  h2:
    console:
      enabled: true
      path: /h2-console
      settings.trace: false
      settings.web-allow-others: false
```

## Architecture
     This demo has been developed following hexagonal architecture
1. application:
    
    Use cases and business logic

2. domain:

    Models and ports

3. infrastructure
    
    Adapters, input and output infrastructure

## OpenApi 

1. openapi-generator-maven-plugin

   https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin
   

   Swagger yml:
```yml
	${project.basedir}/src/main/resources/api/demo.yml
```
2. Swagger console:

   http://localhost:8080/demo/swagger-ui/index.html

   listener is an instance of DesktopStateListener which provides callback on status of connections to runtime.

## Test Cases
      Test cases are defined in test class DemoApplicationTests.java
- Test 1: Day 14 at 10:00, product 35455, brand 1 
- Test 2: Day 14 at 16:00, product 35455, brand 1 
- Test 3: Day 14 at 21:00, product 35455, brand 1 
- Test 4: Day 15 at 10:00, product 35455, brand 1 
- Test 5: Day 16 at 21:00, product 35455, brand 1      
   

