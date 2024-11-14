
FROM openjdk:17

EXPOSE 8082

ADD target/kaddem-0.0.1-SNAPSHOT.jar kaddem-0.0.1-SNAPSHOT.jar

# Define the entry point for the container, the command to run your application
ENTRYPOINT ["java", "-jar", "/kaddem-0.0.1-SNAPSHOT.jar"]
