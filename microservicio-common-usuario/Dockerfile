FROM maven:3.6.3-openjdk-16 
ADD ./microservicio-common-usuario/pom.xml /tmp/
ADD ./microservicio-common-usuario/src /tmp/src/
WORKDIR /tmp/

RUN mvn clean install
