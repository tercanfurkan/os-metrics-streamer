FROM maven:3.8-openjdk-17

MAINTAINER tercanfurkan

ENV ROOT_DIR /usr/src/os-metrics-consumer
ENV CERTS_DIR /usr/src/os-metrics-consumer/certs

RUN mkdir -p $CERTS_DIR
WORKDIR $ROOT_DIR

ADD certs/client.* $CERTS_DIR/
ADD certs/jdbc_ca.pem $CERTS_DIR

ADD pom.xml $ROOT_DIR

RUN mvn verify clean --fail-never

ADD . $ROOT_DIR
RUN mvn verify

ADD run.sh $ROOT_DIR
ENTRYPOINT ["/usr/src/os-metrics-consumer/run.sh"]
