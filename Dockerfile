#official OpenJDK base image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory in the container
WORKDIR /app

# Copy your Java application JAR file into the container
COPY target/imx-poc-0.0.1-SNAPSHOT.jar app.jar

# Exposing to port 8080
EXPOSE 8080

#  to run the application
CMD ["java", "-jar", "app.jar"]