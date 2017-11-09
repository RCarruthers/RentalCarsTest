# Rental Cars Technical Assessment

This project was created using Spring Boot and Apache Camel.

## Requirements
To run this project, you must have:
* A JDK installation. 
* A Maven installation. 

## Build/Run Instructions 
From the source directory:
* To build the project,  run `mvn clean install`
* To run the tests, run `mvn test`
* To run the project, run `mvn spring-boot:run`

## API

The jar runs on a Tomcat server on localhost:8080

Available endpoints: 


| Endpoint | Description |
| ------------- | ------------- |
| /getVehiclesByPrice  | Returns a list of vehicles sorted by price in ascending order.  |
| /getVehiclesBySIPP  | Returns a list of vehicles and their specification  |
| /getVehiclesByRating  | Returns a list of the highest rated suppliers per car type in descending order. |
| /getVehiclesByScore  | Returns a list of vehicles sorted by score and supplier rating.  |
