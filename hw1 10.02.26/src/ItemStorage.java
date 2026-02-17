public class ItemStorage<T> {
    private T value;
    public ItemStorage(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void compareWith(T otherValue) {
        if (!((value instanceof T) && (otherValue instanceof T))) {
            System.out.println("Опачки! Ревизия невозможна, объект не найден");
        }
        else {
            if (value == otherValue) {
                System.out.println("Значения идентичны. Контроль качества пройден");
            }
            else {
                System.out.println("Значения не идентичны. Контроль качества не пройден");
            }
        }
    }
}
