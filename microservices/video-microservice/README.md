## Micronaut 3.10.1 Documentation

- [User Guide](https://docs.micronaut.io/3.10.1/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.10.1/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.10.1/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature kafka documentation

- [Micronaut Kafka Messaging documentation](https://micronaut-projects.github.io/micronaut-kafka/latest/guide/index.html)


## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


## Feature test-resources documentation

- [Micronaut Test Resources documentation](https://micronaut-projects.github.io/micronaut-test-resources/latest/guide/)


## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)


## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


https://micronaut-projects.github.io/micronaut-data/3.10.0/guide/index.html#projections

## command line stuff 

post video `curl -s -v -X POST http://localhost:8080/videos -H "Content-Type: application/json" -d '{"title": "Python 101", "tags": "foo,bar", "username": "sdjebbar"}'`

dislike video
`curl -s -v -X PUT http://localhost:8080/videos/4/dislike/sdjebbar -H "Content-Type: application/json" -d '{"id":4 ,"username":"sdjebbar"}'`

like video
`curl -s -v -X PUT http://localhost:8080/videos/4/like/sdjebbar -H "Content-Type: application/json" -d '{"id":4 ,"username":"sdjebbar"}'`

restart container
`docker-compose stop video &&  docker-compose up -d --no-deps video`

