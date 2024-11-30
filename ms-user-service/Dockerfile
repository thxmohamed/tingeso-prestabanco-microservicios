FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} ms-user-service.jar
ENTRYPOINT ["java","-jar","/ms-user-service.jar"]