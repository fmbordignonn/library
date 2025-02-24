FROM eclipse-temurin:21.0.6_7-jdk-alpine-3.21

WORKDIR /app

COPY /build/libs/library-*-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]