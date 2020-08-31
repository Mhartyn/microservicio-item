FROM common:latest AS MAVEN_TOOL_CHAIN

COPY pom.xml /tmp/

COPY src /tmp/src/
WORKDIR /tmp/

RUN mvn clean package -DskipTests

FROM openjdk:12
WORKDIR /tmp/

COPY src /tmp/src/

VOLUME /tmp

COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar microservicio-producto.jar
ENTRYPOINT [ "java", "-jar", "/microservicio-producto.jar" ]


#./mvnw clean package

#FROM openjdk:8
#docker build -t microservicio-producto:v1 .

#docker network create microservicio
#docker run -P --network microservicio microservicio-producto:v1 