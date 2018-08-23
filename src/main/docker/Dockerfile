FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD web-demo-01-0.0.1-SNAPSHOT.jar app.jar
ENV foo xxx
ENV LDAP_HOST=http://192.168.31.249:8201/check \
    LDAP_PORT=389
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]