FROM openjdk:21
COPY build/libs/prj2-spring-20240521-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "--enable-preview", "app.jar"]