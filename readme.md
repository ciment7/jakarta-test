# how to package and deploy jakarta test application on Payara to test distributed tracing 
- [download payara 6.2025.5  (Full)](https://www.payara.fish/downloads/payara-platform-community-edition/) 
- run ```mvn clean install```
- copy application - jakarta-test.war to autodeploy folder on payara
- send GET request via curl ```curl --location 'http://localhost:8080/jakarta-test/api/hello-world```
- send async GET request via curl ```curl --location 'http://localhost:8080/jakarta-test/api/hello-world/async```

I downloaded latest version of EDOT agent and added to {PAYARA_HOME}/glassfish/lib

I added this jvm options to domain.xml
```
<jvm-options>-Dotel.service.name=jakarta-test</jvm-options>
<jvm-options>-Dotel.exporter.otlp.endpoint=http://localhost:8200</jvm-options>
<jvm-options>-Dotel.resource.attributes=environment=dev,service.namespace=com.ciment.test</jvm-options>
<jvm-options>-javaagent:${com.sun.aas.installRoot}/lib/elastic-otel-javaagent-1.4.1.jar</jvm-options>


```