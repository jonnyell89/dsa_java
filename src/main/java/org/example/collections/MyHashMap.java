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

    private int capacity = 16;
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
}
