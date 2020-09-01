FROM mhartyn/ms-comon-usuario:latest AS MAVEN_TOOL_CHAIN
COPY ./microservicio-oauth/pom.xml /tmp/
COPY ./microservicio-oauth/src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package -DskipTests

FROM openjdk:12
VOLUME /tmp
EXPOSE 9100
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar microservicio-oauth.jar
ENTRYPOINT [ "java", "-jar", "/microservicio-oauth.jar" ]

#./mvnw clean package -DskipTests

#FROM openjdk:8
#docker build -t microservicio-oauth:v1 .

#docker network create microservicio
#docker run -p 9100:9100 --name oauth --network microservicio microservicio-oauth:v1 