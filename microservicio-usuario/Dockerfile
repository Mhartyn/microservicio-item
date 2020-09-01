FROM mhartyn/ms-common-usuario:latest AS MAVEN_TOOL_CHAIN
COPY ./microservicio-usuario/pom.xml /tmp/
COPY ./microservicio-usuario/src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package -DskipTests

FROM openjdk:12
VOLUME /tmp
COPY --from=MAVEN_TOOL_CHAIN ./target/*.jar microservicio-usuario.jar
ENTRYPOINT [ "java", "-jar", "/microservicio-usuario.jar" ]

#./mvnw clean package

#FROM openjdk:8
#docker build -t microservicio-usuario:v1 .

#docker network create microservicio
#docker run -P --network microservicio microservicio-usuario:v1 