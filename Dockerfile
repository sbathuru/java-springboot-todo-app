
FROM openjdk:8-jdk-alpine
ENV APP java-springboot-todo
ENV VERSION 1.0.0-SNAPSHOT
ADD target/$APP-$VERSION.war /app.war
ENTRYPOINT ["java","-jar","app.war"]
EXPOSE 8080

