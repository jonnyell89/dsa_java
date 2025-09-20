package org.example.collections;

import java.util.Arrays;

public class MyQueue {

    protected final MyArray data;

    public MyQueue() {
        this.data = new MyArray();
    }

    public boolean isEmpty() { return data.getSize() == 0; }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("MyQueue is empty.");
        return data.read(0);
    }

    public int add(int element) {
        data.insertAtEnd(element);
        return element;
    }

    public int remove() {
        if (isEmpty()) throw new RuntimeException("MyQueue is empty.");
        int frontElement = data.read(0);
        data.deleteFromStart();
        return frontElement;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "data=" + Arrays.toString(Arrays.copyOf(data.toArray(), data.getSize())) +
                '}';
    }
}
