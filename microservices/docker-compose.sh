#!/bin/bash

# Change directory to video-microservice
cd "./video-microservice" || exit

# Run './gradlew dockerBuild'
./gradlew dockerBuild

# Change directory to video-microservice
cd "../trending-microservice" || exit

# Run './gradlew dockerBuild'
./gradlew dockerBuild

# Change back to the parent directory
cd "../" || exit

# Run 'docker-compose'
docker-compose up -d
