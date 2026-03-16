public class LinkedListNode<E> {
    E data;
    LinkedListNode<E> next;
    LinkedListNode<E> prev;

    public LinkedListNode(E data, LinkedListNode<E> next) {
        this.data = data;
        this.next = next;
    }

    public LinkedListNode(E data) {
        this.data = data;
        this.next = null;
    }

}
