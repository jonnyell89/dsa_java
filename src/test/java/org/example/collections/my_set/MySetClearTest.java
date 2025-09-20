package org.example.collections.my_set;

import org.example.collections.MySet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MySetClearTest {

    private static final int DEFAULT_CAPACITY = 10;

    // CLEAR
    @Test
    void testMySetClearEmptyArray() {
        int[] emptyArray = new int[]{};
        MySet mySet = new MySet();
        mySet.clear();
        assertArrayEquals(emptyArray, mySet.toArray(), "MySet should be equal to emptyArray.");
    }

    @Test
    void testMySetClear() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        MySet mySet = new MySet(array);
        mySet.clear();
        int[] emptyArray = new int[]{};
        assertArrayEquals(emptyArray, mySet.toArray(), "MySet should be equal to emptyArray.");
    }
}
