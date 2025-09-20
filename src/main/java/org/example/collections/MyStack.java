package org.example.collections;

import java.util.Arrays;

public class MyStack {

    protected final MyArray data;

    public MyStack() {
        this.data = new MyArray();
    }

    public boolean isEmpty() { return data.getSize() == 0; }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("MyStack is empty.");
        return data.read(data.getSize() - 1);
    }

    public int push(int element) {
        data.insertAtEnd(element);
        return element;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("MyStack is empty.");
        int topElement = data.read(data.getSize() - 1);
        data.deleteFromEnd();
        return topElement;
    }

    public int search(int element) {
        int size = data.getSize();
        int positionFromTop = 1;
        for (int i = size - 1; i >= 0; i--) {
            if (data.read(i) == element) return positionFromTop;
            positionFromTop++;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "data=" + Arrays.toString(Arrays.copyOf(data.toArray(), data.getSize())) +
                '}';
    }
}
