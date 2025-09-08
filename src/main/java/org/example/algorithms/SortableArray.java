package org.example.algorithms;

import org.example.collections.ManualArray;

public class SortableArray {

    protected ManualArray manualArray;

    public SortableArray(ManualArray manualArray) {
        this.manualArray = manualArray;
    }

    public int partition(int leftPointer, int rightPointer) {
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
            // If the pointers have met, exit the loop to swap the left pointer and the pivot values by index.
            if (leftPointer >= rightPointer) break;
            // If the pointers have not met, swap the left pointer and right pointer values by index.
            else {
                manualArray.swapByIndex(leftPointer, rightPointer);
                leftPointer += 1;
            }
        }
        manualArray.swapByIndex(leftPointer, pivotIndex);
        return leftPointer;
    }

    public void quicksort(int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex <= 0) return; // Base case.
        int pivotIndex = partition(leftIndex, rightIndex);
        quicksort(leftIndex, pivotIndex - 1);
        quicksort(pivotIndex + 1, rightIndex);
    }

    public int quickselect(int kthLowestValue, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex <= 0) return manualArray.read(leftIndex);
        int pivotIndex = partition(leftIndex, rightIndex);
        if (kthLowestValue < pivotIndex) {
            return quickselect(kthLowestValue, leftIndex, pivotIndex - 1);
        } else if (kthLowestValue > pivotIndex) {
            return quickselect(kthLowestValue, pivotIndex + 1, rightIndex);
        } else {
            return manualArray.read(pivotIndex);
        }
    }

    public boolean hasDuplicate() {
        quicksort(0, manualArray.getSize() - 1);
        int size = manualArray.getSize();
        for (int i = 0; i < size - 1; i++) {
            if (manualArray.read(i) == manualArray.read(i + 1)) return true;
        }
        return false;
    }
}
