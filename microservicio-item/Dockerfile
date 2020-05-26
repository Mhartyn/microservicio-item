FROM openjdk:12
VOLUME /tmp
EXPOSE 8002
ADD ./target/microservicio-item-0.0.1-SNAPSHOT.jar microservicio-item.jar
ENTRYPOINT [ "java", "-jar", "/microservicio-item.jar" ]

#./mvnw clean package

#FROM openjdk:8
#docker build -t microservicio-item:v1 .

#docker network create microservicio
#docker run -p 8002:8002 --name item --network microservicio microservicio-item:v1 