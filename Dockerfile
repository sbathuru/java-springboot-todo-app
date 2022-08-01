FROM openjdk:8-jdk-alpine
ENV APP java-springboot-todo
ENV VERSION 1.0.0-SNAPSHOT

RUN mkdir /app
ADD /target/$APP-$VERSION.jar /app/app.jar

RUN addgroup -S spring 
RUN adduser -S spring -G spring
RUN chown -R spring:spring /app

USER spring

ENTRYPOINT ["java","-jar","/app.jar"]
