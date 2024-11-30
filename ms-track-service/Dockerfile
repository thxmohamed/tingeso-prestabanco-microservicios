FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} ms-track-service.jar
ENTRYPOINT ["java","-jar","/ms-track-service.jar"]