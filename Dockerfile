FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/Movie-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD [ "java", "-jar", "app.jar" ]

LABEL author="BYIRINGIRO ALOYS <byiringiroaloys8@gmail.com>"
LABEL version="1.0"
LABEL description="Spring-boot backend for MovieState Application"