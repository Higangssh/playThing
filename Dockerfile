# Use the official OpenJDK 17 as a parent image
FROM openjdk:17-jdk

CMD ["./gradlew", "clean", "build"]
VOLUME /tmp

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 9000
# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]