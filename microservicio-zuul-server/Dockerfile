FROM maven:3.6.3-openjdk-16 AS MAVEN_TOOL_CHAIN
COPY ./microservicio-zuul-server/pom.xml /tmp/
COPY ./microservicio-zuul-server/src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package -DskipTests

FROM openjdk:12
VOLUME /tmp
EXPOSE 8090
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar zuul-server.jar
ENTRYPOINT [ "java", "-jar", "/zuul-server.jar" ]

#./mvnw clean package -DskipTests

#FROM openjdk:8
#docker build -t zuul-server:v1 .

#docker network create microservicio
#docker run -p 8090:8090 --name zuul-server --network microservicio zuul-server:v1 