public class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }


}

//            buckets = (Node<K, V>[]) new Node[CAPACITY];
//            for (Node<K, V> bucket: copy_buckets) {
//                Node<K, V> copy_bucket;
//                while (bucket != null) {
//                    int index = getBucketIndex(bucket.key);
//
//                    copy_bucket = bucket.next;
//                    bucket.next = buckets[index];
//                    buckets[index] = bucket;
//                    bucket = copy_bucket;
//
//
//                }
//            }