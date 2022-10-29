#!/bin/sh

openssl pkcs12 -export -inkey certs/service.key -in certs/service.cert -out client.keystore.p12 -name service_key -passout pass:$KAFKA_KEYSTORE_PASSWORD
keytool -import -noprompt -file certs/ca.pem -alias CA -keystore client.truststore.jks -storepass $KAFKA_KEYSTORE_PASSWORD -keypass $KAFKA_KEYSTORE_PASSWORD

mv client.* certs
