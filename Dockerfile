
FROM openjdk:17-alpine

ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME

ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} bizweb.jar

EXPOSE 18080

ENTRYPOINT ["java", "-jar", "bizweb.jar"]