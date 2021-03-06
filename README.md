# CatererManagement

The solution consists of a Spring Boot Application named Caterer management.
This will give APIs to Add, insert, update, delete as well as getCaterer by id/name/city

### How to build

Run below command to build the executable JAR.

```
mvn clean package
```
### How to run

#### Run in docker container

Create Application Image

````
docker build -t springboot-mongodb:1.0 .
````

Run below command to start application along with a **mongodb** service in Docker.

```
docker-compose up
```

### API Docs

Navigate to below URL to view API docs.

```
http://localhost:8081/swagger-ui/index.html
```
