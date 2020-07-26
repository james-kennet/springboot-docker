FROM openjdk:8-jdk-alpine
RUN apk update && apk add bash && mkdir -p /app/springboot && mkdir /app/springboot/log
COPY ./target/springboot-docker-1.jar /app/springboot
WORKDIR /app/springboot
RUN touch log/springboot-docker.log
ENTRYPOINT ["java", "-jar", "springboot-docker-1.jar"]
