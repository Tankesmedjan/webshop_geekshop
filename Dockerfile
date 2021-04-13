FROM maven:3.8.1-jdk-11 AS MAVEN_BUILD

COPY pom.xml .
COPY src src

RUN mvn package -DskipTests

FROM openjdk:11

COPY --from=MAVEN_BUILD /target/GeekSqueek-0.0.1-SNAPSHOT.jar geeksqueek-backend.jar

ENTRYPOINT ["java", "-jar", "/geeksqueek-backend.jar"]
