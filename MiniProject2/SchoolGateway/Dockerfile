FROM openjdk:12
VOLUME /target
ADD target/school-gateway-0.0.1-SNAPSHOT.jar app2.jar
EXPOSE 8080
RUN bash -c 'touch /app2.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app2.jar","-db"]