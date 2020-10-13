# os-metrics
Stream OS system metrics as events to the DB

## Setting up and running the producer

- Add the `service.cert`, `service.key` files under `metrics-producer/certs`
- `export KAFKA_KEYSTORE_PASS=<keystore_password>`
- Run `./run-producer.sh`

