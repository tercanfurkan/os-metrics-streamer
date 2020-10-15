#!/bin/bash

module=$1
./generate-keystore.sh
./spread_certs.sh
pushd metrics-consumer
./build-consumer.sh
./start-consumer.sh
popd
