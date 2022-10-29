package fi.tercanfurkan.os.metrics.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collection;
import java.util.Properties;

import static fi.tercanfurkan.os.metrics.consumer.ConsumerApp.CERTS_PATH;

public class MetricsConsumer {

    private static String SERVICE_URI = System.getProperty("kafka.service.uri");
    private static String SSL_TRUSTSTORE_LOCATION = CERTS_PATH + "client.truststore.jks";
    private static String SSL_KEYSTORE_LOCATION = CERTS_PATH + "client.keystore.p12";
    private static String KAFKA_KEYSTORE_PASSWORD = System.getProperty("kafka.keystore.password");
    private static String SSL_KEY_PASSWORD = System.getProperty("ssl.key.password");

    public final KafkaConsumer<String, String> consumer;

    public MetricsConsumer() {
        consumer = createConsumer();
    }

    private static KafkaConsumer<String, String> createConsumer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", SERVICE_URI);
        props.put("security.protocol", "SSL");
        props.put("ssl.endpoint.identification.algorithm", "");
        props.put("ssl.truststore.location", SSL_TRUSTSTORE_LOCATION);
        props.put("ssl.truststore.password", KAFKA_KEYSTORE_PASSWORD);
        props.put("ssl.keystore.type", "PKCS12");
        props.put("ssl.keystore.location", SSL_KEYSTORE_LOCATION);
        props.put("ssl.keystore.password", SSL_KEY_PASSWORD);
        props.put("ssl.key.password", SSL_KEY_PASSWORD);
        props.put("group.id", "demo-group");
        props.put("key.deserializer",
            "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
            "org.apache.kafka.common.serialization.StringDeserializer");
        return new KafkaConsumer<>(props);
    }

    public void subscribe(Collection<String> topics) {
        consumer.subscribe(topics);
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s",
                    record.offset(), record.key(), record.value());
            }
        }
    }

    public void close() {
        consumer.unsubscribe();
        consumer.close();
    }
}
