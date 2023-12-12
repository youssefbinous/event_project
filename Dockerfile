# Use the official OpenJDK 8 image as the base image
FROM openjdk:8

# Expose the port your application will run on
EXPOSE 8089

# Set environment variables
ENV NEXUS_USERNAME=admin
ENV NEXUS_PASSWORD=nexus
ENV NEXUS_REPO_URL=http://192.168.33.10:8081/repository/maven-releases/tn/esprit/eventsProject/1.2/eventsProject-1.2.jar

# Download the JAR file from Nexus and copy it to the container
RUN curl -L -o event.jar -u $NEXUS_USERNAME:$NEXUS_PASSWORD $NEXUS_REPO_URL

# Define the entry point for your application
ENTRYPOINT ["java", "-jar", "event.jar"]
