# ==== Stage 1: Build (optional if you've already built jar) ====
# FROM maven:3.9.6-eclipse-temurin-21 AS builder
# WORKDIR /app
# COPY . .
# RUN mvn clean package -DskipTests

# ==== Stage 2: Runtime ====
FROM eclipse-temurin:21-jre AS runtime

WORKDIR /app

# Copy only the built .jar from local machine or previous stage
COPY target/crm-MT5-0.0.1-SNAPSHOT.jar app.jar

# Expose application port
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
