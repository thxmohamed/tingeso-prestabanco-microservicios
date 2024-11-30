FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} ms-request-service.jar
ENTRYPOINT ["java","-jar","/ms-request-service.jar"]