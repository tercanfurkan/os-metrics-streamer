package fi.tercanfurkan.os.metrics.producer;

import fi.tercanfurkan.os.metrics.reader.MetricsReader;

public class ProducerApp {

    public static void main(String[] args) {
        start();
        MetricsProducer kafkaProducer = new MetricsProducer();
        startOsMetricsListener(kafkaProducer);
        kafkaProducer.sendMessage("hello metric");
        kafkaProducer.close();
    }

    private static void start() {
        MetricsProducer producer = new MetricsProducer();
        MetricsReader reader = new MetricsReader(producer);
    }
}
