FROM openjdk:17
WORKDIR /app
COPY . /app
CMD ["./gradlew", "clean", "bootJar"]
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
