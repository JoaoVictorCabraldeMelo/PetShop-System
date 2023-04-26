# Build Stage
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Dev Stage
FROM openjdk:17-jdk-alpine3.14
ARG JAR_FILE=target/*.jar
COPY --from=build /app/${JAR_FILE} app.jar 
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Ddebug", "-Dspring.profiles.active=dev", "/app.jar"]
