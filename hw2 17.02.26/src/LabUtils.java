public class LabUtils {
    public static LaboratoryItem findMaxHazard(LaboratoryItem[] items) {
        LaboratoryItem max = items[0];
        for (LaboratoryItem item : items) {
            if (item.getBiohazardLevel() > max.getBiohazardLevel()) {
                max = item;
            }   
        }
        return max;
    }

    public static void generateReport(ResearchHub<?> hub) {
        for (int i = 0; i < hub.getCount(); i++) {
            LaboratoryItem item = hub.get(i);
            String name = (item instanceof MedicalDevice) ? 
                ((MedicalDevice) item).getDeviceName() : ((ResearchSample) item).getMaterialName();
            System.out.println("[" + item.getClass().getSimpleName() + "] ID: " + item.getSerialNumber() + " | Имя: " + name);
        }
    }

    public static void compareHubTypes(ResearchHub<?> h1, ResearchHub<?> h2) {
        System.out.println(h1.getClass() == h2.getClass());
    }
}
