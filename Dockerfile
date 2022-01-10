FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#FROM openjdk:11
#EXPOSE 80
#ADD build/libs/survey-0.0.1-SNAPSHOT.jar survey-0.0.1
#ENTRYPOINT ["java","-jar","survey-0.0.1-SNAPSHOT.jar"]