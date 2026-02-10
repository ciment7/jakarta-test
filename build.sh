#!/bin/bash

# Build the project
./mvnw clean package

# Build and run the docker container
docker-compose up --build
