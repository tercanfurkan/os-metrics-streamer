# os-metrics
Stream OS system metrics as events through Kafka to PostgreSql DB.

## Modules

### Kafka Producer
Java application running in a docker container. Currently it only sends a single message to the `os-metrics` topic of the Kafka cloud service.

### Kafka Consumer
Java application running in a docker container. Currently it only subscribes to the `os-metrics` topic on the cloud Kafka instance and prints the messages to system out. It also makes a connection to the PostgreSQL cloud service.

## Prerequisites
- Install docker
- Install [direnv](https://direnv.net/docs/installation.html)

## Configuring the environment variables
Java applications rely on some environment variable. [direnv](https://direnv.net/docs/installation.html) is used here. 

Create a `.envrc` file in root dir and fill it based on the `example.envrc` template. Here's a sample .envrc file:
```bash
export KAFKA_SERVICE_URI=<kafka_hostname>:<kafka_port>
export KAFKA_KEYSTORE_PASSWORD=<kafka_keystore_password>
export POSTGRES_JDBC_URL=jdbc:postgresql://<pg_hostnane>:<pg_port>/<pg_db_name>
export POSTGRES_DB_USER=<pg_user>
export POSTGRES_DB_PASSWORD=<pg_password>
export SSL_KEY_PASSWORD=<password_used_to_generate_the_kafka_ssl_keystore>
```

## Setting up and running the producer & consumer services

- For Kafka ssl configuration put the `service.cert`, `service.key`, `ca.pem` files inside the `certs` folder
- For postgresql ssl configuration put the `jdbc_ca.pem` file inside the same `certs` folder
- Fill a `.envrc` file based on the `example.envrc`, then run `direnv allow`
- Run `./fireup-consumer.sh` to build and start the Kafka consumer
- Run `./fireup-producer.sh` to build and start the Kafka producer

