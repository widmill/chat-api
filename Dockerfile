FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
EXPOSE 9000
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]