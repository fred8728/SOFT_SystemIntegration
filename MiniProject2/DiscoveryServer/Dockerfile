FROM openjdk:12
VOLUME /target
ADD target/eureka-server-0.0.1-SNAPSHOT.jar app5.jar
EXPOSE 8080
RUN bash -c 'touch /app5.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app5.jar","-db"]