package org.example.collections;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<T> {

    private static class Node<T> {

        private T data;
        private Node<T> prev;
        private Node<T> next;

        private Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int getSize() { return size; }

    public boolean isEmpty() { return size == 0; }

    // Tells if the argument is the index of an existing element.
    // private boolean isElementIndex(int index) { return index >= 0 && index < size; }

    // Tells if the argument is the index of a valid position for an iterator or an add operation.
    // private boolean isPositionIndex(int index) { return index >= 0 && index <= size; }

    // GUARDS
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    private void checkHead() {
        if (head == null) throw new NoSuchElementException("MyDoublyLinkedList is empty.");
    }

    // READ
    public T read(int index) {
        // Time complexity: O(N)
        checkHead();
        checkElementIndex(index);

        Node<T> node;

        if (index < size / 2) {
            node = head;

            for (int i = 0; i < index; i++) { // Iterate up to index.
                node = node.next;
            }
            return node.data;
        } else {
            node = tail;

            for (int i = size - 1; i > index; i--) { // Iterate down to index.
                node = node.prev;
            }
            return node.data;
        }
    }

    // SEARCH
    public int search(T data) {
        // Time complexity: O(N)
        checkHead();

        Node<T> node = head;

        for (int i = 0; i < size; i++) { // Iterate to the end.
            if (node.data.equals(data)) return i;
            node = node.next;
        }
        return -1;
    }

    // INSERT
    public void insertAtStart(T data) {
        // Time complexity: O(1)
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void insertAtEnd(T data) {
        // Time complexity: O(1)
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insertAtIndex(int index, T data) {
        // Time complexity: O(N)
        checkPositionIndex(index);
        if (index == 0) { insertAtStart(data); return; }
        if (index == size) { insertAtEnd(data); return; }

        Node<T> nodeAtIndex;

        if (index < size / 2) {
            nodeAtIndex = head;

            for (int i = 0; i < index; i++) {
                nodeAtIndex = nodeAtIndex.next;
            }
        } else {
            nodeAtIndex = tail;

            for (int i = size - 1; i > index; i--) {
                nodeAtIndex = nodeAtIndex.prev;
            }
        }
        Node<T> node = new Node<>(data);
        insertNode(node, nodeAtIndex);
        size++;
    }

    private void insertNode(Node<T> node, Node<T> nodeAtIndex) {
        Node<T> prev = nodeAtIndex.prev;
        node.next = nodeAtIndex;
        nodeAtIndex.prev = node;
        prev.next = node;
        node.prev = prev;
    }

    // DELETE
    public T deleteFromStart() {
        // Time complexity: O(1)
        checkHead();

        T data = head.data;
        Node<T> next = head.next;
        head.data = null;
        head.next = null;

        if (next == null) {
            head = null;
            tail = null;
        } else {
            head = next;
            head.prev = null;
        }
        size--;
        return data;
    }

    public T deleteFromEnd() {
        // Time complexity: O(1)
        checkHead();
        if (size == 1) return deleteFromStart();

        T data = tail.data;
        Node<T> prev = tail.prev;
        tail.data = null;
        tail.prev = null;
        tail = prev;
        tail.next = null;
        size--;
        return data;
    }

    public T deleteFromIndex(int index) {
        // Time complexity: O(N)
        checkHead();
        checkElementIndex(index);
        if (index == 0) return deleteFromStart();
        if (index == size - 1) return deleteFromEnd();

        Node<T> node;

        if (index < size / 2) {
            node = head;

            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;

            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        T data = node.data;
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        prev.next = next;
        next.prev = prev;
        node.data = null;
        node.next = null;
        node.prev = null;
        size--;
        return data;
    }

    // Chapter 14: Node-based Data Structures.

    // Exercise 2:
    public void printInReverse() {
        Node<T> node = tail;

        for (int i = size - 1; i > 0; i--) {
            System.out.println(node.data);
            node = node.prev;
        }
    }
}
