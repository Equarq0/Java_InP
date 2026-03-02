public class Main {
    public static void main(String[] args) {
        s1(); s2(); s3(); s4(); s5();
    }

    static void s1() {
        System.out.println("Сценарий 1");
        ResearchHub<ResearchSample<Double>> hub = new ResearchHub<>(); 
        // hub.register(new MedicalDevice("A", 1, 1, "A", 1));
        // Тип S ограничен ResearchSample = MedicalDevice не подходит = ошибка компиляции.
    }

    static void s2() {
        System.out.println("Сценарий 2");
        ResearchHub<LaboratoryItem> hub = new ResearchHub<>();
        hub.register(new MedicalDevice("A", 1, 1, "A", 1));
        hub.register(new ResearchSample<>("B", 1, 1, "A", 1));
        hub.register(new ResearchSample<>("C", 1, 1, "A", 1));
        System.out.println(hub.getCount());
        hub.release(1);
        LabUtils.generateReport(hub);
    }

    static void s3() {
        System.out.println("Сценарий 3");
        ResearchHub<ResearchSample<?>> hub = new ResearchHub<>();
        hub.register(new ResearchSample<>("A", 1, 1, "A", 0.5));
        hub.register(new ResearchSample<>("A", 1, 1, "A", 50));
        hub.register(new ResearchSample<>("A", 1, 1, "A", new Fraction(1,2)));
        hub.adjustPurity(10, 0.5);
        System.out.println(hub.getAveragePurity());
    }

    static void s4() {
        System.out.println("Сценарий 4");
        ResearchHub<LaboratoryItem> hub = new ResearchHub<>();
        MedicalDevice m1 = new MedicalDevice("A", 1, 1, "A", 1);
        System.out.println(hub.checkSession(m1, 100));
        
        MedicalDevice m2 = new MedicalDevice("A", 1, 1, "A", 1);
        System.out.println(hub.checkSession(m2, 250));
        // т.к интеджер кэширует значение от -128 до 127, то тру, а когда выходит за эти рамки то фолс
    }

    static void s5() {
        System.out.println("Сценарий 5");
        LaboratoryItem[] items = {
            new MedicalDevice("A", 2, 1, "A", 1), new MedicalDevice("A", 9, 1, "A", 1),
            new MedicalDevice("A", 4, 1, "A", 1), new MedicalDevice("A", 10, 1, "A", 1),
            new MedicalDevice("A", 3, 1, "A", 1)
        };
        System.out.println(LabUtils.findMaxHazard(items).getSerialNumber());
        ResearchHub<LaboratoryItem> hub = new ResearchHub<>();
        for(LaboratoryItem i : items) hub.register(i);
        hub.clearByHazardLevel(5);
        LabUtils.generateReport(hub);
        LabUtils.compareHubTypes(hub, new ResearchHub<MedicalDevice>());
    }
}