FROM openjdk:12
VOLUME /target
ADD target/student-info-0.0.1-SNAPSHOT.jar app1.jar
EXPOSE 8090
RUN bash -c 'touch /app1.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app1.jar","-db"]