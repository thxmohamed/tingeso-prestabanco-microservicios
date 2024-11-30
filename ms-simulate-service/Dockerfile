FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} ms-simulate-service.jar
ENTRYPOINT ["java","-jar","/ms-simulate-service.jar"]