FROM openjdk:8 
VOLUME /tmp
EXPOSE 8888
ADD ./target/microservicio-config-server-0.0.1-SNAPSHOT.jar config-server.jar
ENTRYPOINT [ "java", "-jar", "/config-server.jar" ]

#FROM openjdk:12
#docker build -t config-server:v1 .

#docker network create microservicio
#docker run -p 8888:8888 --name config-server --network microservicio config-server:v1 