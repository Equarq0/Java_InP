@FunctionalInterface
public interface Validator<T> {
    boolean check(T item);
}

