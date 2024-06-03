FROM openjdk:17

# Instalar Maven
RUN apt-get update && \
    apt-get install -y maven

WORKDIR /app

COPY . .

RUN cd demo && mvn clean install
