#!/bin/sh

# Setup

# Create combined Cert+Key from PEM files
cat $SRC_PATH_KEY $SRC_PATH_CRT > /tmp/cert.pem

# Create PKCS12 version of PEM input
openssl pkcs12 -export -out client.keystore.p12 -in /tmp/cert.pem -passout pass:$TARGET_PASSWORD

# Add PKCS12 version to the empty Java keystore
keytool -v -importkeystore -srckeystore client.keystore.p12 -srcstoretype PKCS12 -destkeystore client.truststore.jks -deststoretype pkcs12 -storepass password -srcstorepass $TARGET_PASSWORD

# Change alias of keys
keytool -changealias -storepass password -keystore client.truststore.jks -alias 1 -destalias $TARGET_ALIAS

# Change password of keystore to target password
keytool -storepasswd -storepass password -new $TARGET_PASSWORD -keystore client.truststore.jks

# Move result to target location
mv client.keystore.p12 client.truststore.jks $CERTS_DIR

# Cleanup
rm /tmp/cert.pem