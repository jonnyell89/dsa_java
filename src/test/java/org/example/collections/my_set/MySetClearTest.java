package org.example.collections.my_set;

import org.example.collections.MySet;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MySetClearTest {

    List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5);

    // CLEAR
    @Test
    void testMySetClearEmptySet() {
        MySet<Integer> mySet = new MySet<>();
        mySet.clear();
        Integer[] result = new Integer[]{};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }

    @Test
    void testMySetClear() {
        MySet<Integer> mySet = new MySet<>(inputList);
        mySet.clear();
        Integer[] result = new Integer[]{};
        assertArrayEquals(result, mySet.toArray(), "MySet should be equal to result.");
    }
}
