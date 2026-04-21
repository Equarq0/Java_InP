import java.util.Objects;

abstract public class Entity<T> {
    protected T id;
    public T getId() { return id; }

    @Override
    public abstract String toString();
}


