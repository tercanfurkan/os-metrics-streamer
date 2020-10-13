#!/bin/bash

docker run -it --rm \
        -e KAFKA_KEYSTORE_PASS=$KAFKA_KEYSTORE_PASS \
        --name producer \
        os-metrics-producer