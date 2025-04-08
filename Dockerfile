# Use OpenJDK 21 slim version
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar file into container
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]


