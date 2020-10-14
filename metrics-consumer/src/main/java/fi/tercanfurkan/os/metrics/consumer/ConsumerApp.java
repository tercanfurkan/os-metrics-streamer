package fi.tercanfurkan.os.metrics.consumer;

import java.sql.Connection;
import java.util.Arrays;

public class ConsumerApp {

    protected static String CERTS_PATH = System.getProperty("user.dir") + "/certs/";

    private static String TOPIC = "os-metrics";

    public static void main(String[] args) {
        MetricsConsumer consumer = new MetricsConsumer();
        Connection conn = DbConnect.createConnection();
        consumer.subscribe(Arrays.asList(TOPIC));
    }
}
