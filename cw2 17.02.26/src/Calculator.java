public class Calculator {
    public static <T extends Number, N extends Number> double add(T a, N b) {
        return a.doubleValue() + b.doubleValue();
    }
    public static<T extends Number, N extends Number> double subtract(T a, N b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static<T extends Number, N extends Number> double multiply(T a, N b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static<T extends Number, N extends Number> double divide(T a, N b) {
        if (b.doubleValue() != 0)
            return a.doubleValue() / b.doubleValue();
        else {
            throw new NullPointerException();
        }
    }

    
    
}
