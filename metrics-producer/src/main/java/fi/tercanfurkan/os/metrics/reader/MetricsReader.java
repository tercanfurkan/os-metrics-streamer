package fi.tercanfurkan.os.metrics.reader;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import fi.tercanfurkan.os.metrics.producer.MetricsProducer;
import org.apache.kafka.clients.producer.KafkaProducer;

public class MetricsReader {

    private final ScheduledExecutorService scheduledExecutor;
    private final MetricsProducer producer;

    public MetricsReader(MetricsProducer producer) {
        this.scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.producer = producer;
    }

    public void start() {
        scheduledExecutor.scheduleAtFixedRate(MetricsReader::read, 0, 1, TimeUnit.SECONDS);
    }

    private static void read() {
        
    }
}
