FROM openjdk:12
VOLUME /tmp
ADD ./target/microservicio-item-0.0.1-SNAPSHOT.jar microservicio-item.jar
ENTRYPOINT [ "java", "-jar", "/microservicio-item.jar" ]

#./mvnw clean package

#FROM openjdk:8
#docker build -t microservicio-item:v1 .

#docker network create microservicio
#docker run -P --network microservicio microservicio-item:v1 