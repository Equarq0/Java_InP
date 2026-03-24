import java.util.Arrays;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private Node<K, V>[] buckets;
    private int size;
    private static int CAPACITY = 16;

    public MyHashMap() {
        buckets = (Node<K, V>[]) new Node[CAPACITY];
        size = 0;
    }

    @Override
    public V put(K key, V value) {
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }
        resize();
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
        return null;
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % buckets.length)  ;
    }

    @Override
    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];
        if (current == null) return null;
        if (current.key.equals(key)) {
            buckets[index] = current.next;
            size--;
            return current.value;
        }
        while (current.next != null) {
            if (current.next.key.equals(key)) {
                Node<K, V> removed = current.next;
                current.next = current.next.next;
                size--;
                return removed.value;
            }
            current = current.next;
        }
    return null;
    }

    @Override
    public boolean containsKey(K key) {
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (Node<K, V> bucket: buckets) {
            while (bucket != null) {
                if (bucket.value.equals(value)) {
                    return true;
                }
                bucket = bucket.next;
            }
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
        buckets = (Node<K, V>[]) new Node[CAPACITY];
        size = 0;
    }

    public void resize() {
        if (size == CAPACITY) {
            CAPACITY *= 2;
            Node<K, V>[] copy_buckets = buckets;
            this.buckets = (Node<K, V>[]) new Node[CAPACITY];
            for (Node<K, V> bucket: copy_buckets) {
                Node<K, V> next_bucket = bucket;
                while (next_bucket != null) {
                    next_bucket = bucket.next;
                    int index = getBucketIndex(bucket.key);
                    bucket.next = buckets[index];
                    buckets[index] = bucket;
                    bucket = next_bucket;
                }
            }
        }
    }
}