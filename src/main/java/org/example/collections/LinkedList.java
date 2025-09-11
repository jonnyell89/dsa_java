package org.example.collections;

public class LinkedList<T> {

    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    private Node<T> getHead() { return head; }

    private void setHead(Node<T> head) { this.head = head; }

    public int getSize() { return size; }

    // private void incrementSize() { size++; }

    // private void decrementSize() { size--; }

    // Tells if the argument is the index of an existing element.
    // private boolean isElementIndex(int index) { return index >= 0 && index < size; }

    // Tells if the argument is the index of a valid position for an iterator or an add operation.
    // private boolean isPositionIndex(int index) { return index >= 0 && index <= size; }

    // READ
    public T read(int index) {
        // Time complexity: O(N)
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    private Node<T> node(int index) {
        // Time complexity: O(N)
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // SEARCH
    public int search(T data) {
        // Time complexity: O(N)
        Node<T> node = head;
        for (int i = 0; i < size - 1; i++) {
            if (node.data.equals(data)) return i;
            node = node.next;
        }
        throw new IllegalArgumentException("Node not present in LinkedList." + data);
    }

    private int indexOf(T data) {
        // Time complexity: O(N)
        int index = 0;
        for (Node<T> node = head; node.next != null; node = node.next) {
            if (data.equals(node.data)) return index;
            index++;
        }
        return -1;
    }

    // INSERT
    public void insertAtStart(T data) {
        // Time complexity: O(1)
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
        size++;
    }

    public void insertAtEnd(T data) {
        // Time complexity: O(1)
        if (size == 0) {
            insertAtStart(data);
            return;
        }
        // Time complexity: O(N)
        Node<T> newNode = new Node<>(data);
        Node<T> node = head;
        for (int i = 0; i < size - 1; i++) {
            node = node.next;
        }
        node.next = newNode;
        size++;
    }

    public void insertAtIndex(int index, T data) {
        // Time complexity: O(N)
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        if (index == 0) {
            insertAtStart(data);
            return;
        }
        Node<T> newNode = new Node<>(data);
        Node<T> node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    // DELETE
}
