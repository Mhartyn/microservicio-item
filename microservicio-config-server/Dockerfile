FROM maven:3.6.3-openjdk-16 AS MAVEN_TOOL_CHAIN
COPY ./microservicio-config-server/pom.xml /tmp/
COPY ./microservicio-config-server/src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package -DskipTests

FROM openjdk:12
VOLUME /tmp
EXPOSE 8888
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar config-server.jar
ENTRYPOINT [ "java", "-jar", "/config-server.jar" ]

#FROM openjdk:12
#docker build -t config-server:v1 .

#docker network create microservicio
#docker run -p 8888:8888 --name config-server --network microservicio config-server:v1 