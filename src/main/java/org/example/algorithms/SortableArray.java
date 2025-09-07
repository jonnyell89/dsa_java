package org.example.algorithms;

import org.example.collections.ManualArray;

public class SortableArray {

    protected ManualArray manualArray;

    public SortableArray(ManualArray manualArray) {
        this.manualArray = manualArray;
    }

    public void partition(int leftPointer, int rightPointer) {
        int pivotIndex = rightPointer;
        int pivot = manualArray.read(pivotIndex);
        rightPointer -= 1;
        while (true) {
            while (manualArray.read(leftPointer) < pivot) {
                leftPointer += 1;
            }
            while (manualArray.read(rightPointer) > pivot) {
                rightPointer -= 1;
            }
            if (leftPointer >= rightPointer) break;
            else {
                manualArray.swapByIndex(leftPointer, rightPointer);
                leftPointer += 1;
            }
        }
    }
}
