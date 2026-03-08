import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
    private T[] array = (T[]) new Object[10];
    private int size = 10;
    private int count = 0;

    @Override
    public void add(T item) {
        if (count >= size) {
            size = (int) (size * 1.5);
            array = Arrays.copyOf(array, (size));
        }
        array[count++] = item;

    }

    @Override
    public void add(int index, T item) {
        if (count >= size) {
            size = (int) (size * 1.5);
            array = Arrays.copyOf(array, (size));
        }
        if (index > count || index < 0) throw new IndexOutOfBoundsException("Index out of range");

        for (int i = count - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = item;
        count++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException("Index out of bounds");
        return array[index];
    }

    @Override
    public T remove(int index) {
        T deleted = array[index];
        if (index == count - 1) {
            array[index] = null;
            count--;
            return deleted;
        }
        if (index > count || index < 0) throw new IndexOutOfBoundsException("Index out of range");
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
        array[count] = null;
        return deleted;
    }

    @Override
    public boolean remove(T item) {
        for (int i = 0; i < count; i ++) {
            if (array[i].equals(item)) {
                if (count - 1 == i) {
                    count--;
                    array[count] = null;
                    return true;
                }
                for (int j = i; j < count - 1; j++) array[j] = array[j + 1];
                count--;
                array[count] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clear() {
        T[] empty = (T[]) new Object[10];
        array = empty;
        count = 0;
    }

    @Override
    public boolean contains(T item) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < count; i ++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}
