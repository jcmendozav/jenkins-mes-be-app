FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
ARG CONFIG_FILE=application.properties
COPY ${JAR_FILE} app.jar
COPY ${CONFIG_FILE} app.properties
ENTRYPOINT ["java","-Dspring.config.location=/app.properties","-jar","/app.jar"]