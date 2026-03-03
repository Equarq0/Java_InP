public class MyLinkedList<T> implements MyList<T> {

    private Node<T> head;
    private int size;

    @Override
    public void add(T item) {
        if (head == null) {head = new Node<>(item);}
        else {
            Node<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(item);
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index out of range");
        }
        else if (index == 0) {
            head = new Node<>(item, head);
        }
        else {
            Node<T> node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            node.next = new Node<>(item, node.next);
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index out of range");
        }
        else {
            Node<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.data;
        }
    }

    @Override
    public T remove(int index) {
        T removed;
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index out of range");
        }
        else {
            Node<T> node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            removed = node.next.data;
            node.next = node.next.next;
            size--;
            return removed;
        }
    }

    @Override
    public boolean remove(T item) {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.next.data.equals(item)) {
                node.next = node.next.next;
                size--;
                return true;    
            }
            node = node.next;
        }
        return false;
        }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(T item) {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(item)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object item) {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(item)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }
    
}
