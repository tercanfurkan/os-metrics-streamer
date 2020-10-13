#!/bin/bash

pushd metrics-producer
./build-producer.sh
./start-producer.sh
popd