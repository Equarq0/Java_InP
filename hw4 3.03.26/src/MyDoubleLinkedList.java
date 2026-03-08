public class MyDoubleLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    private Node<T> findNodeFast(int index) {
        if (index < (size >> 1)) {
            Node<T> node = head;
            for (int i = 0; i < index; i++) node = node.next;
            return node;
        } else {
            Node<T> node = tail;
            for (int i = size - 1; i > index; i--) node = node.prev;
            return node;
        }
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == size) {
            add(item);
            return;
        }
        Node<T> nextNode = findNodeFast(index);
        Node<T> prevNode = nextNode.prev;
        Node<T> node = new Node<>(item);
        node.next = nextNode;
        node.prev = prevNode;
        nextNode.prev = node;
        if (prevNode == null) {
            head = node;
        } else {
            prevNode.next = node;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return findNodeFast(index).data;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> nodeToRemove = findNodeFast(index);
        unlink(nodeToRemove);
        return nodeToRemove.data;
    }

    @Override
    public boolean remove(T item) {
        Node<T> node = head;
        int index = 0;
        while (node != null) {
            if (item.equals(node.data)) {
                unlink(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private void unlink(Node<T> current) {
        Node<T> next = current.next;
        Node<T> prev = current.prev;
        if (prev != null) prev.next = next;
        else head = next;
        if (next != null) next.prev = prev;
        else tail = prev;
        size--;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(T item) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (item.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
}