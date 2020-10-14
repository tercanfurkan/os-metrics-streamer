#!/bin/bash

./spread_certs.sh
pushd metrics-consumer
./build-consumer.sh
./start-consumer.sh
popd
