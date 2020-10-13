#!/bin/bash
echo $KAFKA_KEYSTORE_PASS
java -Dkafka.keystore.pass=$KAFKA_KEYSTORE_PASS -jar target/metrics-producer-0.1-SNAPSHOT-jar-with-dependencies.jar