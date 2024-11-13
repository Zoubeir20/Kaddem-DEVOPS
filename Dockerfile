# Use an OpenJDK base image
FROM openjdk:8-jdk-alpine
# Copy the Spring Boot JAR file into the container
COPY ./target/kaddem-0.0.1-SNAPSHOT.jar kaddem.jar
# Expose the port the app will run on (matches the spring port in application.properties)
EXPOSE 8089
# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "kaddem.jar"]
