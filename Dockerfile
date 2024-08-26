FROM openjdk:17
EXPOSE 8181
ADD target/retail-backend.jar retail-backend.jar
ENTRYPOINT ["java","-jar","/retail-backend.jar"]

