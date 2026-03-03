public class CustomsTerminal {
    public static void inspectCargo(CargoBay<? extends Cargo> Bay) {
        for (int i = 0; i < Bay.getSize(); i++) {
            Cargo item = Bay.get(i);
            if (item != null) {
                System.out.println(item.getName());
            }
        }
    }

    public static void loadHumanitarianApples(CargoBay<? super Food> Bay) {
        Fruit[] apples = new Fruit[2];
        apples[0] = new Fruit("Яблоко1");
        apples[1] = new Fruit("Яблоко2");
        for (int i = 0; i < apples.length; i++) {
            Bay.add(apples[i]);
        }
    }

    public static <T> void transferCargo(CargoBay<? extends T> src, CargoBay<? super T> dest) {
        T[] items = src.getAll();
        for (int i = 0; i < src.getSize(); i++) {
            if (items[i] != null) {
                dest.add(items[i]);
            }
        }
    }
}
