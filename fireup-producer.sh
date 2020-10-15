#!/bin/bash

module=$1
./generate-keystore.sh
./spread_certs.sh
pushd metrics-producer
./build-producer.sh
./start-producer.sh
popd
