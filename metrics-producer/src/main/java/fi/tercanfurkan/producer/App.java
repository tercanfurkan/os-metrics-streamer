package fi.tercanfurkan.producer;

public class App {

    public static void main(String[] args) {
        MetricsProducer producer = new MetricsProducer();
        producer.sendMessage("hello metric");
        producer.close();
    }
}
