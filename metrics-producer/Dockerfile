#FROM maven:3.2.5-jdk-8u40
FROM maven:3.5.3-jdk-8-alpine

MAINTAINER tercanfurkan

ENV ROOT_DIR /usr/src/os-metrics-producer
ENV CERTS_DIR /usr/src/os-metrics-producer/certs

RUN mkdir -p $CERTS_DIR
WORKDIR $ROOT_DIR

ADD certs/client.* $CERTS_DIR/

ADD pom.xml $ROOT_DIR

RUN mvn verify clean --fail-never

ADD . $ROOT_DIR
RUN mvn verify

ADD run.sh $ROOT_DIR
ENTRYPOINT ["/usr/src/os-metrics-producer/run.sh"]
