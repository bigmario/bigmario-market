FROM gradle:7.6.2-jdk17-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar

FROM amazoncorretto:17-alpine3.17 AS development
COPY --from=build /home/gradle/src/build/libs/*.jar /opt/app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=dev","-jar","/opt/app.jar"]

FROM amazoncorretto:17-alpine3.17 AS production
COPY --from=build /home/gradle/src/build/libs/*.jar /opt/app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=pdn","-jar","/opt/app.jar"]