public class MyDoubleLinkedList<T> implements MyList<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    @Override
    public void add(T item) {
        LinkedListNode<T> node = new LinkedListNode<>(item);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    private LinkedListNode<T> findNodeFast(int index) {
        if (index < (size >> 1)) {
            LinkedListNode<T> node = head;
            for (int i = 0; i < index; i++) node = node.next;
            return node;
        } else {
            LinkedListNode<T> node = tail;
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
        LinkedListNode<T> nextNode = findNodeFast(index);
        LinkedListNode<T> prevNode = nextNode.prev;
        LinkedListNode<T> node = new LinkedListNode<>(item);
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
        LinkedListNode<T> nodeToRemove = findNodeFast(index);
        unlink(nodeToRemove);
        return nodeToRemove.data;
    }

    @Override
    public boolean remove(T item) {
        LinkedListNode<T> node = head;
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

    private void unlink(LinkedListNode<T> current) {
        LinkedListNode<T> next = current.next;
        LinkedListNode<T> prev = current.prev;
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
        LinkedListNode<T> current = head;
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