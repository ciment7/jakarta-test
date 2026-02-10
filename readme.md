# how to package and deploy jakarta test application on Payara to test distributed tracing 
- [download payara 6.2024.12  (Full)](https://www.payara.fish/downloads/payara-platform-community-edition/) 
- run ```mvn clean install```
- copy application - jakarta-test.war to autodeploy folder on payara
- send GET request via curl ```curl --location 'http://localhost:8080/jakarta-test/api/hello-world```

I added this jvm options to domain.xml
```
<jvm-options>-Delastic.apm.application_packages=com.ciment.test</jvm-options>
<jvm-options>-Delastic.apm.service_name=jakarta-test</jvm-options>
<jvm-options>-Delastic.apm.log_sending=true</jvm-options>
<jvm-options>-Delastic.apm.server_urls=http://localhost:8200</jvm-options>
<jvm-options>-Delastic.apm.environment=dev</jvm-options>
<jvm-options>-javaagent:${com.sun.aas.installRoot}/lib/elastic-apm-agent-1.52.1.jar</jvm-options>


```

## Docker Build and Run

To build the project and run it in a Docker container, use the `build.sh` script:

```bash
./build.sh
```

This will:
1. Build the Maven project and create the `.war` file.
2. Build the Docker image using the provided `Dockerfile`.
3. Start the application using `docker-compose`.

You can then send a test request using:
```bash
curl --location 'http://localhost:8080/jakarta-test/api/hello-world'
curl --location 'http://localhost:8080/jakarta-test/api/hello-world/async'
```