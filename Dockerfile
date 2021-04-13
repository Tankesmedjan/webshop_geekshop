FROM openjdk:11 as build

COPY mvnw .
COPY .mvn .mvn

COPY pom.xml .
RUN ./mvn dependency:go-offline -B

COPY src src

RUN ./mvn package -DskipTests
FROM openjdk:11

COPY /target/GeekSqueek-0.0.1-SNAPSHOT.jar geeksqueek-backend.jar

ENTRYPOINT ["java", "-jar", "/geeksqueek-backend.jar"]