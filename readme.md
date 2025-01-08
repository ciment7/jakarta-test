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