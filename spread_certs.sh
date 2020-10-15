#!/bin/bash

cp certs/client.* metrics-consumer/certs
cp certs/jdbc_ca.pem metrics-consumer/certs

cp certs/client.* metrics-producer/certs
