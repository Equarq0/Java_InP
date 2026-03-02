public abstract class LaboratoryItem {
    private String serialNumber;
    private int biohazardLevel;
    private Integer sessionID;
    public LaboratoryItem(String serialNumber, int biohazardLevel, Integer sessionID) {
        this.serialNumber = serialNumber;
        this.biohazardLevel = biohazardLevel;
        this.sessionID = sessionID;
    }

    public String getSerialNumber() { return serialNumber; }
    public int getBiohazardLevel() { return biohazardLevel; }
    public Integer getSessionID() { return sessionID; }
}


