FROM maven:3.9.4-eclipse-temurin-17 AS build

ENV HOME=/usr/app

RUN mkdir -p $HOME

WORKDIR $HOME

ADD . $HOME

RUN mvn clean package

FROM openjdk:17

COPY --from=build /usr/app/target/*.jar /app/app.jar

ENV JAVA_OPTS=""

CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar" ]