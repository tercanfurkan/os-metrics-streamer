#FROM maven:3.2.5-jdk-8u40
FROM maven:3.5.3-jdk-8-alpine

MAINTAINER tercanfurkan

ENV ROOT_DIR /usr/src/os-metrics-producer
ENV CERTS_DIR /usr/src/os-metrics-producer/certs


RUN mkdir -p $ROOT_DIR
WORKDIR $ROOT_DIR

### Start generate keystore out of pem
# Credit goes to: https://github.com/justjanne/pem-to-keystore
RUN apk add --update openssl && \
    rm -rf /var/cache/apk/*

ADD certs/service.key $CERTS_DIR/service.key
ADD certs/service.cert $CERTS_DIR/service.cert
ADD generate-keystore.sh $ROOT_DIR/generate-keystore.sh
RUN chmod 744 $ROOT_DIR/generate-keystore.sh
ENV SRC_PATH_CRT $CERTS_DIR/service.key
ENV SRC_PATH_KEY $CERTS_DIR/service.cert
ENV TARGET_PASSWORD password
ENV TARGET_ALIAS key

RUN $ROOT_DIR/generate-keystore.sh
### End generate keystore out of pem

ADD pom.xml $ROOT_DIR/pom.xml

RUN mvn verify clean --fail-never

ADD . $ROOT_DIR
RUN mvn verify

ADD run.sh $ROOT_DIR/run.sh
ENTRYPOINT ["/usr/src/os-metrics-producer/run.sh"]
