# 1) stage cache dependencies
FROM maven:3.9.9-eclipse-temurin-21-jammy AS deps
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 2) stage build
FROM deps AS builder
COPY src ./src
RUN mvn clean package -DskipTests -B

# 3) stage runtime
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]