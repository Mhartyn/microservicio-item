FROM openjdk:12
VOLUME /tmp
ADD ./target/microservicio-producto-0.0.1-SNAPSHOT.jar microservicio-producto.jar
ENTRYPOINT [ "java", "-jar", "/microservicio-producto.jar" ]

#./mvnw clean package

#FROM openjdk:8
#docker build -t microservicio-producto:v1 .

#docker network create microservicio
#docker run -P --network microservicio microservicio-producto:v1 