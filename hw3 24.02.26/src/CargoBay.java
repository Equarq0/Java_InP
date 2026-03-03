import java.util.Arrays;

public class CargoBay<T> {
    T[] items;
    int size;
    public CargoBay(int size) {
        this.size = 0;
        this.items = (T[]) new Object[size];
        
    }
    public void add(T item) {
        if (size == items.length) {
            items = Arrays.copyOf(items, size * 2);
        }
        items[size++] = item;
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return items[index];
        }
        throw new ArrayIndexOutOfBoundsException("Index out of range");
    }

    public T[] getAll() {
        return items;
    }

    public int getSize() {
        return size;
    }
}