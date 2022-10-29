package fi.tercanfurkan.os.metrics.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;


public class MetricsProducer {

    private static String TOPIC = "os-metrics";
    private static String CERTS_PATH = System.getProperty("user.dir") + "/certs/";
    private static String SERVICE_URI = System.getProperty("kafka.service.uri");
    private static String SSL_TRUSTSTORE_LOCATION = CERTS_PATH + "client.truststore.jks";
    private static String SSL_KEYSTORE_LOCATION = CERTS_PATH + "client.keystore.p12";
    private static String KAFKA_KEYSTORE_PASSWORD = System.getProperty("kafka.keystore.password");
    private static String SSL_KEY_PASSWORD = System.getProperty("ssl.key.password");

    public final Producer<String, String> producer;

    public MetricsProducer() {
        producer = createProducer();
    }

    public static Producer<String, String> createProducer() {
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
        props.put("key.serializer",
            "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
            "org.apache.kafka.common.serialization.StringSerializer");

        return new KafkaProducer<String, String>(props);
    }

    public void sendMessage(String message) {
        ProducerRecord<String, String> data = new ProducerRecord<String, String>(
            TOPIC, message);
        producer.send(data, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e != null) {
                    System.out.println("Error while producing message to topic :" + recordMetadata);
                    e.printStackTrace();
                } else {
                    String message = String.format("sent message to topic:%s partition:%s  offset:%s", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
                    System.out.println(message);
                }
            }
        });
    }

    public void close() {
        producer.close();
    }
}
