FROM openjdk:12
VOLUME /tmp
EXPOSE 8761
ADD ./target/microservicio-eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
ENTRYPOINT [ "java", "-jar", "/eureka-server.jar" ]

#./mvnw clean package

#FROM openjdk:8
#docker build -t eureka-server:v1 .

#docker network create microservicio
#docker run -p 8761:8761 --name eureka-server --network microservicio eureka-server:v1 