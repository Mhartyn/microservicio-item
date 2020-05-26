FROM openjdk:12
VOLUME /tmp
EXPOSE 9100
ADD ./target/microservicio-oauth-0.0.1-SNAPSHOT.jar microservicio-oauth.jar
ENTRYPOINT [ "java", "-jar", "/microservicio-oauth.jar" ]

#./mvnw clean package -DskipTests

#FROM openjdk:8
#docker build -t microservicio-oauth:v1 .

#docker network create microservicio
#docker run -p 9100:9100 --name oauth --network microservicio microservicio-oauth:v1 