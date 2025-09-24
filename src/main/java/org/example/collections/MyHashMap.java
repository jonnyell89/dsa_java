package org.example.collections;

public class MyHashMap<K, V> {

    private static class Node<K, V> {

        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private final int DEFAULT_CAPACITY = 16;

    private int capacity = DEFAULT_CAPACITY;
    private float loadFactor = 0.75f;
    private int size;
    private Node<K, V>[] data;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        data = new Node[capacity];
    }

    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> head = data[index];

        for (Node<K, V> node = head; node != null; node = node.next) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        data[index] = new Node<>(key, value, head);
        size++;

        if ((float)size / capacity >= loadFactor) {
            ensureCapacity();
        }
    }

    public V get(K key) {
        int index = hash(key);

        for (Node<K, V> node = data[index]; node != null; node = node.next) {
            if (node.key.equals(key)) return node.value;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        Node<K, V> head = data[index];
        Node<K, V> dummy = new Node<>(null, null, head);

        for (Node<K, V> node = dummy; node.next != null; node = node.next) {
            if (node.next.key.equals(key)) {
                V value = node.next.value;
                node.next.key = null;
                node.next.value = null;
                node.next = node.next.next;
                data[index] = dummy.next;
                size--;
                return value;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity() {
        if ((float)size / capacity >= loadFactor) {
            capacity = capacity * 2;
            size = 0;
            Node<K, V>[] oldData = data;
            data = new Node[capacity];

            for (Node<K, V> head : oldData) {
                for (Node<K, V> node = head; node != null; node = node.next) {
                    put(node.key, node.value);
                }
            }
        }
    }
}
