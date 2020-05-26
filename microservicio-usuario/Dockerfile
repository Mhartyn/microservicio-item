FROM openjdk:12
VOLUME /tmp
EXPOSE 8003
ADD ./target/microservicio-usuario-0.0.1-SNAPSHOT.jar microservicio-usuario.jar
ENTRYPOINT [ "java", "-jar", "/microservicio-usuario.jar" ]

#./mvnw clean package

#FROM openjdk:8
#docker build -t microservicio-usuario:v1 .

#docker network create microservicio
#docker run -p 8003:8003 --name usuario --network microservicio microservicio-usuario:v1 