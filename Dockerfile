# Step 1: Use Amazon Corretto 17 as the base image
FROM amazoncorretto:17-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the Spring Boot jar into the container
COPY target/productService-0.0.1-SNAPSHOT.jar /app/my-app.jar

# Step 4: Expose the port the app will run on (default 8080 for Spring Boot)
EXPOSE 2020

# Step 5: Define the command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/my-app.jar","--debug"]