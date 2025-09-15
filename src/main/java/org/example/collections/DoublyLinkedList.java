package org.example.collections;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {

    private static class Node<T> {

        private T data;
        private Node<T> prev;
        private Node<T> next;

        private Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        private Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private Node<T> getHead() { return head; }

    private void setHead(Node<T> head) { this.head = head; }

    private Node<T> getTail() { return tail; }

    private void setTail(Node<T> tail) { this.tail = tail; }

    public int getSize() { return size; }

    // Tells if the argument is the index of an existing element.
    // private boolean isElementIndex(int index) { return index >= 0 && index < size; }

    // Tells if the argument is the index of a valid position for an iterator or an add operation.
    // private boolean isPositionIndex(int index) { return index >= 0 && index <= size; }

    // READ
    public T read(int index) {
        // Time complexity: O(N)
        if (head == null) throw new NoSuchElementException("DoublyLinkedList is empty.");
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        if (index < size / 2) {
            Node<T> node = head;
            for (int i = 0; i < index; i++) { // Iterate up to index.
                node = node.next;
            }
            return node.data;
        } else {
            Node<T> node = tail;
            for (int i = size - 1; i > index; i--) { // Iterate down to index.
                node = node.prev;
            }
            return node.data;
        }
    }

    // SEARCH
    public int search(T data) {
        // Time complexity: O(N)
        if (head == null) throw new NoSuchElementException("DoublyLinkedList is empty.");
        Node<T> node = head;
        for (int i = 0; i < size - 1; i++) { // Iterate to the end.
            if (node.data.equals(data)) return i;
            node = node.next;
        }
        throw new IllegalArgumentException("Node not present in DoublyLinkedList.");
    }

    // INSERT
    public void insertAtStart(T data) {
        // Time complexity: O(1)
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
        if (tail == null) tail = node;
        size++;
    }

    public void insertAtEnd(T data) {
        // Time complexity: O(1)
        Node<T> node = new Node<>(data);
        node.prev = tail;
        tail = node;
        if (head == null) head = node;
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
        if (index < size / 2) {
            Node<T> node = head;
            for (int i = 0; i < index - 1; i++) { // Iterate up to node before index.
                node = node.next;
            }
            Node<T> nodeAtIndex = node.next;
            newNode.next = nodeAtIndex;
            nodeAtIndex.prev = newNode;
            node.next = newNode;
            newNode.prev = node;
        } else {
            Node<T> node = tail;
            for (int i = size - 1; i > index - 1; i--) { // Iterate down to node before index.
                node = node.prev;
            }
            Node<T> nodeAtIndex = node.next;
            newNode.next = nodeAtIndex;
            nodeAtIndex.prev = newNode;
            node.next = newNode;
            newNode.prev = node;
        }
        size++;
    }

    private void insertNode(Node<T> newNode, Node<T> nodeAtIndex) {
        Node<T> prevNode = nodeAtIndex.prev;
        newNode.next = nodeAtIndex;
        nodeAtIndex.prev = newNode;
        prevNode.next = newNode;
        newNode.prev = prevNode;
    }
}
