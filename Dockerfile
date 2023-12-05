FROM openjdk:17
EXPOSE 8082
ADD target/schedule-service.jar schedule-service.jar
ENTRYPOINT ["java","-jar","/schedule-service.jar"]