FROM maven:3.6.3-openjdk-16 

COPY pom.xml /tmp/

COPY src /tmp/src/
WORKDIR /tmp/

RUN mvn clean install

#RUN ls