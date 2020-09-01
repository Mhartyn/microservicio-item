FROM maven:3.6.3-openjdk-16 

ADD ./microservicio-common/pom.xml /tmp/

ADD ./microservicio-common/src /tmp/src/
WORKDIR /tmp/

RUN mvn clean install

#RUN ls