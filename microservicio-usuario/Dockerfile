FROM openjdk:12
VOLUME /tmp
ADD ./target/microservicio-usuario-0.0.1-SNAPSHOT.jar microservicio-usuario.jar
ENTRYPOINT [ "java", "-jar", "/microservicio-usuario.jar" ]

#./mvnw clean package

#FROM openjdk:8
#docker build -t microservicio-usuario:v1 .

#docker network create microservicio
#docker run -P --network microservicio microservicio-usuario:v1 