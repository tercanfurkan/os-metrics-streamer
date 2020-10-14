#FROM maven:3.2.5-jdk-8u40
FROM maven:3.5.3-jdk-8-alpine

MAINTAINER tercanfurkan

ENV ROOT_DIR /usr/src/os-metrics-consumer
ENV CERTS_DIR /usr/src/os-metrics-consumer/certs

RUN mkdir -p $CERTS_DIR
WORKDIR $ROOT_DIR

### Start generate keystore out of pem
# Credit goes to: https://github.com/justjanne/pem-to-keystore
RUN apk add --update openssl && \
    rm -rf /var/cache/apk/*

ADD certs/service.key $CERTS_DIR
ADD certs/service.cert $CERTS_DIR
ADD certs/jdbc_ca.pem $CERTS_DIR
ADD generate-keystore.sh $ROOT_DIR
RUN chmod 744 $ROOT_DIR/generate-keystore.sh
ENV SRC_PATH_CRT $CERTS_DIR/service.key
ENV SRC_PATH_KEY $CERTS_DIR/service.cert
ENV TARGET_PASSWORD password
ENV TARGET_ALIAS key

RUN $ROOT_DIR/generate-keystore.sh
### End generate keystore out of pem

ADD pom.xml $ROOT_DIR

RUN mvn verify clean --fail-never

ADD . $ROOT_DIR
RUN mvn verify

ADD run.sh $ROOT_DIR
ENTRYPOINT ["/usr/src/os-metrics-consumer/run.sh"]
