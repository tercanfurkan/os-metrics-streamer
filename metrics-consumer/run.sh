#!/bin/bash

java \
  -Dkafka.service.uri=$KAFKA_SERVICE_URI \
  -Dkafka.keystore.password=$KAFKA_KEYSTORE_PASSWORD \
  -Dpostgres.jdbc.url=$POSTGRES_JDBC_URL \
  -Dpostgres.db.user=$POSTGRES_DB_USER \
  -Dpostgres.db.password=$POSTGRES_DB_PASSWORD \
  -jar target/metrics-consumer-0.1-SNAPSHOT-jar-with-dependencies.jar