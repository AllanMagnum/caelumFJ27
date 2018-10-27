FROM openjdk:8-jre-alpine

ARG JAR_FILE

RUN mkdir /app

COPY ${JAR_FILE} /app/default.jar

WORKDIR /app

EXPOSE 8080

CMD java -jar default.jar