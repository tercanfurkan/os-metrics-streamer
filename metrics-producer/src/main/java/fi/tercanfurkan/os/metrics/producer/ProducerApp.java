package fi.tercanfurkan.os.metrics.producer;

import fi.tercanfurkan.os.metrics.reader.MetricsReader;

public class ProducerApp {

    public static void main(String[] args) {
        MetricsProducer producer = new MetricsProducer();
        producer.sendMessage("hello metric");
        producer.close();
    }
}
