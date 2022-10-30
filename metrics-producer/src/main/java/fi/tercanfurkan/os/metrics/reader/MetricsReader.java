package fi.tercanfurkan.os.metrics.reader;

import fi.tercanfurkan.os.metrics.reader.model.SystemProperties;
import fi.tercanfurkan.os.metrics.reader.model.SystemStats;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class MetricsReader {

    private final SystemInfo systemInfo = new SystemInfo();
    private final HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();
    private final CentralProcessor centralProcessor = hardwareAbstractionLayer.getProcessor();
    private long[] prevSystemCpuLoadTicks = new long[CentralProcessor.TickType.values().length];

    public SystemProperties readSystemInfo() {
        return new SystemProperties(hardwareAbstractionLayer.getMemory().getTotal());
    }

    public SystemStats readSystemStats() {
        double cpuLoad = centralProcessor.getSystemCpuLoadBetweenTicks(prevSystemCpuLoadTicks);
        prevSystemCpuLoadTicks = centralProcessor.getSystemCpuLoadTicks();
        return new SystemStats(cpuLoad, hardwareAbstractionLayer.getMemory().getAvailable());
    }
}
