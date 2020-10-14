#!/bin/bash

./spread_certs.sh
pushd metrics-producer
./build-producer.sh
./start-producer.sh
popd
