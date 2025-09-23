package org.example.collections;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    private static class Node<T> {

        private T data;
        private Node<T> next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() { return size; }

    public boolean isEmpty() { return size == 0; }

    // Tells if the argument is the index of an existing element.
    // private boolean isElementIndex(int index) { return index >= 0 && index < size; }

    // Tells if the argument is the index of a valid position for an iterator or an add operation.
    // private boolean isPositionIndex(int index) { return index >= 0 && index <= size; }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        Node<T> node = head;

        for (int i = 0; i < size; i++) {
            array[i] = node.data;
            node = node.next;
        }
        return array;
    }

    // GUARDS
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    private void checkHead() {
        if (head == null) throw new NoSuchElementException("MyLinkedList is empty.");
    }

    // READ
    public T read(int index) {
        // Time complexity: O(N)
        checkHead();
        checkElementIndex(index);

        Node<T> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    private Node<T> node(int index) {
        // Time complexity: O(N)
        checkHead();
        checkElementIndex(index);

        Node<T> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // SEARCH
    public int search(T data) {
        // Time complexity: O(N)
        checkHead();

        Node<T> node = head;

        for (int i = 0; i < size - 1; i++) {
            if (node.data.equals(data)) return i;
            node = node.next;
        }
        return -1;
    }

    private int indexOf(T data) {
        // Time complexity: O(N)
        checkHead();

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
        // Time complexity: O(N)
        if (size == 0) { insertAtStart(data); return; }

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
        checkPositionIndex(index);
        if (index == 0) { insertAtStart(data); return; }
        if (index == size) { insertAtEnd(data); return; }

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
    public T deleteFromStart() {
        // Time complexity: O(1)
        checkHead();

        T data = head.data;
        Node<T> next = head.next;
        head.data = null;
        head.next = null;
        head = next;
        size--;
        return data;
    }

    public T deleteFromEnd() {
        // Time complexity: O(N)
        checkHead();
        if (size == 1) return deleteFromStart();

        Node<T> node = head;

        for (int i = 0; i < size - 2; i++) {
            node = node.next;
        }
        Node<T> next = node.next;
        T data = next.data;
        node.next = null;
        next.data = null;
        next.next = null;
        size--;
        return data;
    }

    public T deleteFromIndex(int index) {
        // Time complexity: O(N)
        checkHead();
        checkElementIndex(index);
        if (index == 0) return deleteFromStart();
        if (index == size - 1) return deleteFromEnd();

        Node<T> node = head;

        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        Node<T> next = node.next;
        T data = next.data;
        node.next = node.next.next;
        next.data = null;
        next.next = null;
        size--;
        return data;
    }

    // Chapter 14: Node-based Data Structures.

    // Exercise 1:
    public void print() {
        Node<T> node = head;

        for (int i = 0; i < size; i++) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    // Exercise 3:
    public T last() {
        Node<T> node = head;

        while (node.next != null) {
            node = node.next;
        }
        return node.data;
    }

    // Exercise 4:
    public void reverse() {
        Node<T> prev = null;
        Node<T> node = head;

        while (node != null) {
            Node<T> next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        head = prev;
    }

    // Exercise 5:
    private T deleteMiddleNode(Node<T> node) {
        T data = node.data;
        Node<T> next = node.next;
        node.data = next.data;
        node.next = next.next;
        next.data = null;
        next.next = null;
        return data;
    }

    // 92. Reverse Linked List II
    private Node<T> reverse(Node<T> head, int left, int right) {
        if (head == null || left == right) return head;

        Node<T> dummy = new Node<>(null, head);
        Node<T> prev = dummy;
        Node<T> start = head;
        Node<T> end = head;
        Node<T> next = end.next;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
            start = start.next;
        }

        for (int i = 0; i < right - 1; i++) {
            end = end.next;
            next = next.next;
        }
        Node<T> newPrev = start;
        Node<T> newStart = start.next;

        while (newStart != next) {
            Node<T> newNext = newStart.next;
            newStart.next = newPrev;
            newPrev = newStart;
            newStart = newNext;
        }
        prev.next = end;
        start.next = next;
        return dummy.next;
    }

    private Node<T> reverseFinal(Node<T> head, int left, int right) {
        if (head == null || left == right) return head;

        Node<T> dummy = new Node<>(null, head);
        Node<T> prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        Node<T> current = prev.next;

        // [1, 2, 3, 4, 5], left = 2, right = 4;
        for (int i = 0; i < right - left; i++) {
            Node<T> next = current.next; // next = 3; next = 4;
            current.next = next.next; // 2 -> 4; 2 -> 5;
            next.next = prev.next; // 3 -> 2; 4 -> 3;
            prev.next = next; // 1 -> 3; 1 -> 4;
            // [1, 3, 2, 4, 5]; [1, 4, 3, 2, 5];
        }
        return dummy.next;
    }

    // 82. Remove Duplicates from Sorted List II
    private Node<T> deleteDuplicates(Node<T> head) {
        if (head == null) return null;

        Node<T> dummy = new Node<>(null, head);
        Node<T> prev = dummy;
        Node<T> current = prev.next;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            if (current.next != null && current.data == next.data) {

                while (current.next != null && current.data == next.data) {
                    current = next;
                    next = next.next;
                }
                prev.next = next;
            } else {
                prev = current;
            }
            current = next;
        }
        return dummy.next;
    }

    private Node<T> deleteDuplicatesFinal(Node<T> head) {
        Node<T> dummy = new Node<>(null, head);
        Node<T> prev = dummy.next;
        Node<T> current = head;

        while (current != null) {
            if (current.next != null && current.data == current.next.data) {

                while (current.next != null && current.data == current.next.data) {
                    current = current.next;
                }
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}
