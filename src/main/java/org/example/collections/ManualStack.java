package org.example.collections;

import java.util.EmptyStackException;

public class ManualStack {

    protected final ManualArray data;

    public ManualStack() {
        this.data = new ManualArray();
    }

    public boolean isEmpty() { return data.getSize() == 0; }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return data.read(data.getSize() - 1);
    }

    public int push(int element) {
        data.insertAtEnd(element);
        return element;
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
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
}
