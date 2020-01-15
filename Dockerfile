FROM adoptopenjdk:11-jre-hotspot

COPY build/libs/project-webservice-0.0.1-SNAPSHOT.jar project-webservice.jar
RUN chmod 777 project-webservice.jar
ENTRYPOINT ["java","-jar", "project-webservice.jar"]