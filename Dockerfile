FROM openjdk:11 as build

COPY mvnw .
COPY .mvn .mvn

COPY pom.xml .
RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvn package -DskipTests
FROM openjdk:11

COPY /target/demo-0.0.1-SNAPSHOT.jar webshop.jar

ENTRYPOINT ["java", "-jar", "/webshop.jar"]