package org.example.collections;

public class BinarySearchTree {

    private static class Node {

        private int data;
        private Node left;
        private Node right;

        private Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        private Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() { return size; }

    // READ

    // SEARCH
    public boolean search(int data) {
        return search(root, data);
    }

    private boolean search(Node node, int data) {
        if (node == null) return false; // Base case.
        if (node.data == data) return true; // Base case.
        return data < node.data ? search(node.left, data) : search(node.right, data);
    }

    // INSERT

    // DELETE
}
