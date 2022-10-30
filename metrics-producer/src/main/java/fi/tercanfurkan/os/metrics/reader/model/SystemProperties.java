package fi.tercanfurkan.os.metrics.reader.model;

public class SystemProperties {

    private static final String OS_NAME = System.getProperty("os.name");
    private static final String OS_VERSION = System.getProperty("os.version");
    private static final String OS_ARCH = System.getProperty("os.arch");

    private final String osName = OS_NAME;
    private final String osVersion = OS_VERSION;
    private final String getOsArch = OS_ARCH;
    private final long totalMemory;

    public SystemProperties(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public String getOsName() {
        return osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public String getGetOsArch() {
        return getOsArch;
    }

    public long getTotalMemory() {
        return totalMemory;
    }
}
