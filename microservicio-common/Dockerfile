FROM maven:3.6.3-openjdk-16 

ADD pom.xml /tmp/

ADD src /tmp/src/
WORKDIR /tmp/

RUN mvn clean install

#RUN ls