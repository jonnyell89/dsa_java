package org.example.collections;

import java.util.Arrays;

public class ManualQueue {

    protected final ManualArray data;

    public ManualQueue() {
        this.data = new ManualArray();
    }

    public boolean isEmpty() { return data.getSize() == 0; }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("ManualQueue is empty.");
        return data.read(0);
    }

    public int add(int element) {
        data.insertAtEnd(element);
        return element;
    }

    public int remove() {
        if (isEmpty()) throw new RuntimeException("ManualQueue is empty.");
        int frontElement = data.read(0);
        data.deleteFromStart();
        return frontElement;
    }

    @Override
    public String toString() {
        return "ManualQueue{" +
                "data=" + Arrays.toString(Arrays.copyOf(data.toArray(), data.getSize())) +
                '}';
    }
}
