package org.example.collections;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public Node<T> getHead() { return head; }

    public void setHead(Node<T> head) { this.head = head; }

    public int getSize() { return size; }

    public void incrementSize() { size++; }

    public void decrementSize() { size--; }

    // READ
    public T read(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        Node<T> currentNode = getHead();
        int currentIndex = 0;
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        if (currentNode == null) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        return currentNode.getData();
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
    public boolean insertAtStart(T data) {
        // Time complexity: O(1)
        Node<T> newHead = new Node<>(data);
        Node<T> oldHead = getHead();
        newHead.setNext(oldHead);
        setHead(newHead);
        incrementSize();
        return true;
    }

    public boolean insertAtEnd(T data) {
        // Time complexity: O(N)
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = getHead();
        if (currentNode == null && size == 0) {
            setHead(newNode);
            incrementSize();
            return true;
        }
        int currentIndex = 0;
        while (currentNode != null && currentIndex < (size - 1)) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        if (currentNode != null && currentNode.getNext() == null) {
            currentNode.setNext(newNode);
            incrementSize();
            return true;
        }
        return false;
    }

    public boolean insertAtIndex(int index, T data) {
        // Time complexity: O(N)
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = getHead();
        if (index == 0) {
            setHead(newNode);
            incrementSize();
            return true;
        }
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
            return true;
        }
        return false;
    }

    // DELETE
}
