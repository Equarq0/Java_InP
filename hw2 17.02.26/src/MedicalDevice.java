public class MedicalDevice extends LaboratoryItem {
    private String deviceName;
    private double precision;

    public MedicalDevice(String serialNumber, int biohazardLevel, Integer sessionID, String deviceName, double precision) {
        super(serialNumber, biohazardLevel, sessionID);
        this.deviceName = deviceName;
        this.precision = precision;
    }

    public String getDeviceName() { return deviceName; }
    public double getPrecision() { return precision; }
}
