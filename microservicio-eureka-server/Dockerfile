FROM maven:3.6.3-openjdk-16 AS MAVEN_TOOL_CHAIN
COPY ./microservicio-eureka-server/pom.xml /tmp/
COPY ./microservicio-eureka-server/src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package -DskipTests

FROM openjdk:12
VOLUME /tmp
EXPOSE 8761
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar eureka-server.jar
ENTRYPOINT [ "java", "-jar", "/eureka-server.jar" ]

#./mvnw clean package

#FROM openjdk:8
#docker build -t eureka-server:v1 .

#docker network create microservicio
#docker run -p 8761:8761 --name eureka-server --network microservicio eureka-server:v1 