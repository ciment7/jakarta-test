# Project Overview

This is a Jakarta EE application that exposes a simple REST API. It uses Maven as the build tool and is designed to be deployed on a Payara server. The application includes Elastic APM for distributed tracing.

The main endpoint is at `/api/hello-world`, which returns "Hello, World!". There is also an asynchronous endpoint at `/api/hello-world/async`.

# Building and Running

There are two ways to build and run this project:

**1. Manual Deployment**

- Build the project using Maven:
  ```bash
  ./mvnw clean install
  ```
- This will create a `jakarta-test.war` file in the `target` directory.
- Deploy this `.war` file to your Payara server's `autodeploy` folder.

**2. Docker**

- Run the `build.sh` script:
  ```bash
  ./build.sh
  ```
- This script will build the Maven project, create a Docker image, and start the application using `docker-compose`.

Once the application is running, you can send a test request:

```bash
curl --location 'http://localhost:8080/jakarta-test/api/hello-world'
```

# Development Conventions

- This project uses Jakarta EE 10.
- Testing is done with JUnit 5.
- The project follows a standard Maven project layout.
- Distributed tracing is implemented using Elastic APM. The `@Traced` annotation is used to trace methods, and a `ContainerResponseFilter` adds the trace ID to the HTTP response headers.
