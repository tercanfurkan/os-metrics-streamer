#!/bin/bash

docker run -it --rm \
        -e KAFKA_SERVICE_URI=$KAFKA_SERVICE_URI \
        -e KAFKA_KEYSTORE_PASSWORD=$KAFKA_KEYSTORE_PASSWORD \
        --name producer \
        os-metrics-producer
