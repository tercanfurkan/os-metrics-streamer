#!/bin/sh

openssl pkcs12 -export -inkey certs/service.key -in certs/service.cert -out client.keystore.p12 -name service_key -passout pass:$SSL_KEY_PASSWORD
keytool -import -file certs/ca.pem -alias CA -keystore client.truststore.jks -storepass password -srcstorepass $SSL_KEY_PASSWORD -noprompt

mv client.* certs
