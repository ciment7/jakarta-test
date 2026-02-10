#!/bin/bash
while true; do
  curl --location 'http://localhost:8080/jakarta-test/api/hello-world'
  curl --location 'http://localhost:8080/jakarta-test/api/cdi/hello-world'
  curl --location 'http://localhost:8080/jakarta-test/api/hello-world/async'
  curl --location 'http://localhost:8080/jakarta-test/api/cdi/hello-world/async'
  sleep 1
done
