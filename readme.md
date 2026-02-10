# Jakarta Test Application

This is a Jakarta EE application that exposes a simple REST API. It uses Maven as the build tool and is designed to be
deployed on a Payara server. The application includes Elastic APM for distributed tracing.

## Building and Running

**Docker**

- Run the `build.sh` script:
  ```bash
  ./build.sh
  ```
- This script will build the Maven project, create a Docker image, and start the application using `docker-compose`.

## Testing Endpoints

Once the application is running, you can send a test request to the following endpoints:

- `http://localhost:8080/jakarta-test/api/hello-world`
- `http://localhost:8080/jakarta-test/api/hello-world/async`
- `http://localhost:8080/jakarta-test/api/cdi/hello-world`
- `http://localhost:8080/jakarta-test/api/cdi/hello-world/async`

You can use `curl` to test the endpoints:

```bash
curl --location 'http://localhost:8080/jakarta-test/api/hello-world'
```

Alternatively, you can run the provided script to send requests to all endpoints in a loop:

```bash
./run_curls_in_loop.sh
```
