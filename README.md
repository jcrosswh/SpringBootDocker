# SpringBootDocker

A sample project demonstrating a Spring Boot application in a Docker container.

## Getting Started

For getting started with development and testing.

### SSL Support

Getting SSL working on your machine can be tricky, so that is not a core part of the application (yet).  If you'd like to see how to run this project with SSL enabled please see the SSL branch.

### Prerequisites

To bulid this project you'll need Java 8 JDK and Maven.

Download Docker Toolbox to build the Docker image locally.

This project uses the [MySQL Sakila database v1.1](https://dev.mysql.com/doc/sakila/en/).  To run this application, make sure you have an instance you can connect to.

### Installing

To run the application locally:

Clone the project
```
git clone https://github.com/jcrosswh/SpringBootDocker.git
```
Build the JAR
```
mvn clean test jar:jar
```

Build the Docker image
```
mvn package
```

### Running Locally

#### Running Stand-Alone Spring Boot

Set the environment variable 'CONNECTION\_HOST' to the host running MySQL and 'CONNECTION\_PASS' to the root password.  If these are not set, the application will fail to start up since it cannot connect to a database.

Run `mvn spring-boot:run`

The application will be available on http://localhost:8080.  Try getting all available inventory for store 1 at http://localhost:8080/api/stores/1/inventory.

#### Running In A Docker Container

Create an env.file with 'CONNECTION\_HOST' and 'CONNECTION\_PASS' set
```
CONNECTION_HOST=10.0.2.2
CONNECTION_PASS=password
```

Run Maven exec on the Docker host
```
mvn exec:exec
```

The application will be available on your Docker host.  For example, try getting all available inventory for store 1 at http://192.168.99.100:8080/api/stores/1/inventory.
