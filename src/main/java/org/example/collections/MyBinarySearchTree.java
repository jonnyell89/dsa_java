package org.example.collections;

public class MyBinarySearchTree<T extends Comparable<T>> {

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

    public MyBinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() { return size; }

    // toArray

    // randomiseArray

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

    private Node<T> searchNode(T data) {
        return searchNode(root, data);
    }

    private Node<T> searchNode(Node<T> node, T data) {
        if (node == null) return null; // Base case.
        int compareTo = data.compareTo(node.data);
        if (compareTo == 0) return node; // Base case.
        return compareTo < 0 ? searchNode(node.left, data) : searchNode(node.right, data); // Recursive step.
    }

    // INSERT
    public boolean insert(T data) {
        if (root == null) {
            root = new Node<>(data);
            size++;
            return true;
        }
        return insert(root, data);
    }

    private boolean insert(Node<T> node, T data) {
        int compareTo = data.compareTo(node.data);
        if (compareTo < 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
                size++;
                return true;
            } else {
                return insert(node.left, data);
            }
        }
        if (compareTo > 0) {
            if (node.right == null) {
                node.right = new Node<>(data);
                size++;
                return true;
            } else {
                return insert(node.right, data);
            }
        }
        return false; // Does not allow duplicates.
    }

    // DELETE
    public boolean delete(T data) {
        int originalSize = size;
        root = delete(root, data);
        return size < originalSize;
    }

    private Node<T> delete(Node<T> node, T dataToDelete) {
        if (node == null) return null; // Base case.
        int compareTo = dataToDelete.compareTo(node.data);
        if (compareTo < 0) {
            node.left = delete(node.left, dataToDelete); // Recursive step.
            return node;
        }
        if (compareTo > 0) {
            node.right = delete(node.right, dataToDelete); // Recursive step.
            return node;
        }
        if (node.left == null) {
            size--;
            return node.right;
        } else if (node.right == null) {
            size--;
            return node.left;
        } else {
            node.right = lift(node.right, node);
            return node;
        }
    }

    private Node<T> lift(Node<T> node, Node<T> nodeToDelete) {
        if (node.left != null) {
            node.left = lift(node.left, nodeToDelete);
            return node;
        } else {
            nodeToDelete.data = node.data;
            return node.right;
        }
    }
}
