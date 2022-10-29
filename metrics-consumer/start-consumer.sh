#!/bin/bash

docker run -it --rm \
        -e KAFKA_SERVICE_URI=$KAFKA_SERVICE_URI \
        -e KAFKA_KEYSTORE_PASSWORD=$KAFKA_KEYSTORE_PASSWORD \
        -e SSL_KEY_PASSWORD=SSL_KEY_PASSWORD \
        -e POSTGRES_JDBC_URL=$POSTGRES_JDBC_URL \
        -e POSTGRES_DB_USER=$POSTGRES_DB_USER \
        -e POSTGRES_DB_PASSWORD=$POSTGRES_DB_PASSWORD \
        --name consumer \
        os-metrics-consumer
