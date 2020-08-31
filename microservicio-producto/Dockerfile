FROM maven:3.6.3-jdk-14 AS MAVEN_TOOL_CHAIN
#maven:3.5.2-jdk-8-alpine
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package -DskipTests

FROM openjdk:12
VOLUME /tmp
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/microservicio-producto-0.0.1-SNAPSHOT.jar microservicio-producto.jar
ENTRYPOINT [ "java", "-jar", "/microservicio-producto.jar" ]

#./mvnw clean package

#FROM openjdk:8
#docker build -t microservicio-producto:v1 .

#docker network create microservicio
#docker run -P --network microservicio microservicio-producto:v1 