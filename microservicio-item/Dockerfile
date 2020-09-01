FROM mhartyn/ms-common:latest AS MAVEN_TOOL_CHAIN
COPY ./microservicio-item/pom.xml /tmp/
COPY ./microservicio-item/src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package -DskipTests

FROM openjdk:12
VOLUME /tmp
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar microservicio-item.jar
ENTRYPOINT [ "java", "-jar", "/microservicio-item.jar" ]

#./mvnw clean package

#FROM openjdk:8
#docker build -t microservicio-item:v1 .

#docker network create microservicio
#docker run -P --network microservicio microservicio-item:v1 