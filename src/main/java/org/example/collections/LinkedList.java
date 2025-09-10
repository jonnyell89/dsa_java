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

//    public Node<T> getHead() { return head; }

//    public void setHead(Node<T> head) { this.head = head; }

    public int getSize() { return size; }

    public void incrementSize() { size++; }

    public void decrementSize() { size--; }

    // Tells if the argument is the index of an existing element.
    private boolean isElementIndex(int index) { return index >= 0 && index < size; }

    // Tells if the argument is the index of a valid position for an iterator or an add operation.
    private boolean isPositionIndex(int index) { return index >= 0 && index <= size; }

    // READ
    public T read(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        Node<T> currentNode = head;
        int currentIndex = 0;
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        assert currentNode != null;
        return currentNode.data;
    }

    public T readData(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    private Node<T> readNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    // SEARCH
    public int search(T data) {
        Node<T> currentNode = getHead();
        int currentIndex = 0;
        while (currentNode != null) {
            if (currentNode.getData().equals(data)) return currentIndex;
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        throw new IllegalArgumentException("Node not present in LinkedList." + data);
    }

    // INSERT
    public void insertAtStart(T data) {
        // Time complexity: O(1)
        Node<T> newHead = new Node<>(data);
        Node<T> oldHead = getHead();
        newHead.setNext(oldHead); // Point newHead to oldHead.
        setHead(newHead); // Set newHead as head.
        incrementSize();
    }

    public void insertAtEnd(T data) {
        // Time complexity: O(1)
        if (size == 0) {
            insertAtStart(data);
            return;
        }
        // Time complexity: O(N)
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = getHead();
        int currentIndex = 0;
        while (currentNode != null && currentIndex < (size - 1)) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        if (currentNode != null && currentNode.getNext() == null) {
            currentNode.setNext(newNode);
            incrementSize();
        }
    }

    public void insertAtIndex(int index, T data) {
        // Time complexity: O(N)
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        if (index == 0) {
            insertAtStart(data);
            return;
        }
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = getHead();
        int currentIndex = 0;
        while (currentNode != null && currentIndex < (index - 1)) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        if (currentNode != null) {
            Node<T> newNext = currentNode.getNext();
            newNode.setNext(newNext);
            currentNode.setNext(newNode);
            incrementSize();
        }
    }

    // DELETE
}
