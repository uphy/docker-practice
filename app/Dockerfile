FROM openjdk:8-alpine

RUN mkdir /usr/src
COPY src/* /usr/src

WORKDIR /usr/src
RUN javac SimpleHttpServer.java

EXPOSE 8000

CMD java SimpleHttpServer