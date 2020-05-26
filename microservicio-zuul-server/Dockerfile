FROM openjdk:12
VOLUME /tmp
EXPOSE 8090
ADD ./target/microservicio-zuul-server-0.0.1-SNAPSHOT.jar zuul-server.jar
ENTRYPOINT [ "java", "-jar", "/zuul-server.jar" ]

#./mvnw clean package -DskipTests

#FROM openjdk:8
#docker build -t zuul-server:v1 .

#docker network create microservicio
#docker run -p 8090:8090 --name zuul-server --network microservicio zuul-server:v1 