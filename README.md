# os-metrics
Stream OS system metrics as events to the DB

## Prerequisites
- Install docker
- Install [direnv](https://direnv.net/docs/installation.html)

## Setting up and running the producer & consumer

- For Kafka ssl configuration put the `service.cert`, `service.key` files inside the `certs` folder
- For postgresql ssl configuration put the `jdbc_ca.pem` file inside the same `certs` folder
- Create and fill a `.envrc` file based on the `example.envrc` template, then run `direnv allow`
- Run `./fireup-consumer.sh` to build and start the Kafka consumer
- Run `./fireup-producer.sh` to build and start the Kafka producer

