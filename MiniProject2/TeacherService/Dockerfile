FROM openjdk:12
VOLUME /target
ADD target/teacher-0.0.1-SNAPSHOT.jar app3.jar
EXPOSE 8080
RUN bash -c 'touch /app3.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app3.jar","-db"]