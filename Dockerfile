FROM maven:3.8-openjdk-8 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:18-ea-8-jdk-slim
COPY --from=build /target/homeservo-0.0.1-SNAPSHOT.jar homeservo.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","homeservo.jar" ]