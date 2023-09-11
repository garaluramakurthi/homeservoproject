FROM maven:3.8-openjdk-8 AS build
COPY . .
RUN ls -la  # List files in the current directory (debugging)
RUN mvn clean package -DskipTests
RUN ls -la target  # List files in the target directory after build (debugging)


FROM openjdk:18-ea-8-jdk-slim
COPY --from=build /target/homeservo-0.0.1-SNAPSHOT.jar homeservo.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","homeservo.jar" ]