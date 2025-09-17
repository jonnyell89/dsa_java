package org.example.collections;

public class BinarySearchTree<T extends Comparable<T>> {

    private static class Node<T> {

        private T data;
        private Node<T> left;
        private Node<T> right;

        private Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        private Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node<T> root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() { return size; }

    // READ

    // SEARCH
    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(Node<T> node, T data) {
        if (node == null) return false; // Base case.
        int compareTo = data.compareTo(node.data);
        if (compareTo == 0) return true; // Base case.
        return compareTo < 0 ? search(node.left, data) : search(node.right, data); // Recursive step.
    }

    // INSERT
    public boolean insert(T data) {
        return search(root, data);
    }

    private boolean insert(Node<T> node, T data) {
        int compareTo = data.compareTo(node.data);
        if (compareTo < 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
                return true;
            } else {
                return insert(node, data);
            }
        }
        if (compareTo > 0) {
            if (node.right == null) {
                node.right = new Node<>(data);
                return true;
            } else {
                return insert(node, data);
            }
        }
        return false;
    }

    // DELETE
}
