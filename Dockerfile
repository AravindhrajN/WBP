
# Use an OpenJDK base image
FROM adoptopenjdk:17-jre-hotspot

# Set working directory inside the container
WORKDIR /app

# Copy the WAR file into the container at /app
COPY target/WBP-0.0.1-SNAPSHOT.war /app

# Expose port 8080 to the outside world
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "WBP-0.0.1-SNAPSHOT.war"]

