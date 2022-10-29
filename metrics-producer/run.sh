#!/bin/bash

java \
  -Dkafka.service.uri=$KAFKA_SERVICE_URI \
  -Dkafka.keystore.password=$KAFKA_KEYSTORE_PASSWORD \
  -Dssl.key.password=$KAFKA_KEYSTORE_PASSWORD \
  -jar target/metrics-producer-0.1-SNAPSHOT-jar-with-dependencies.jar