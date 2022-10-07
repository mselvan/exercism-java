package com.belyf;

import java.util.List;

public class BinarySearch {
    private final List<Integer> list;

    public BinarySearch(List<Integer> list) {
        this.list = list;
    }

    public Integer indexOf(int value) throws ValueNotFoundException {
        int index = binarySearch(list, value);
        if(index < 0) throw new ValueNotFoundException("Value not in array");
        return index;
    }

    private int binarySearch(List<Integer> list, int value) {
        return runBinarySearchRecursively(list, value, 0, list.size() - 1);
    }

    public int runBinarySearchRecursively(List<Integer> sortedList, int valueToFind, int low, int high) {
        int middle = low  + ((high - low) / 2);
        if (high < low) {
            return -1;
        }
        if (valueToFind == sortedList.get(middle)) {
            return middle;
        } else if (valueToFind < sortedList.get(middle)) {
            return runBinarySearchRecursively(
                    sortedList, valueToFind, low, middle - 1);
        } else {
            return runBinarySearchRecursively(sortedList, valueToFind, middle + 1, high);
        }
    }
}
