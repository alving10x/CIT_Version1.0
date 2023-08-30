FROM eclipse-temurin:17-jdk-alpine
LABEL maintainer="author@jose.com"
ADD target/cit-springmongoservice.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]