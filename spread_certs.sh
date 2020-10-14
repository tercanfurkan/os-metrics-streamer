#!/bin/bash

cp certs/* metrics-consumer/certs
cp certs/service.* metrics-producer/certs
cp generate-keystore.sh metrics-consumer
cp generate-keystore.sh metrics-producer
