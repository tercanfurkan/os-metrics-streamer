package fi.tercanfurkan.os.metrics.reader.model;

public class SystemStats {
    private double cpuLoadPercentage;
    private long availableMemory;

    public SystemStats(double cpuLoadPercentage, long availableMemory) {
        this.cpuLoadPercentage = cpuLoadPercentage;
        this.availableMemory = availableMemory;
    }

    public double getCpuLoadPercentage() {
        return cpuLoadPercentage;
    }

    public long getAvailableMemory() {
        return availableMemory;
    }
}
