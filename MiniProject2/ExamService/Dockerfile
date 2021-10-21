FROM openjdk:12
VOLUME /target
ADD target/exam-0.0.1-SNAPSHOT.jar app4.jar
EXPOSE 8080
RUN bash -c 'touch /app4.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app4.jar","-db"]