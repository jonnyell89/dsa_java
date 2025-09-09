package org.example.collections;

public class LinkedList {

    private Node head;
    private int size;

    public LinkedList(Node head) {
        this.head = head;
        this.size = 1;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void incrementSize() {
        size++;
    }

    public void decrementSize() {
        size--;
    }

    // READ
    public int read(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        Node currentNode = getHead();
        int currentIndex = 0;
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        if (currentNode == null) throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        return currentNode.getData();
    }

    // SEARCH


    // INSERT


    // DELETE


}
