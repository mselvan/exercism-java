package com.belyf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Matrix {

    private final int rows;
    private final int columns;
    private final List<Integer> elements;

    Matrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\n");
        String[] columns = rows[0].split(" ");
        elements = Arrays.stream(matrixAsString.split("\\W+"))
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
        this.rows = rows.length;
        this.columns = columns.length;
    }

    int[] getRow(int rowNumber) {
        int fromIndex = (rowNumber * columns) - columns;
        int toIndex = fromIndex + columns;
        int[] returnElements = elements.subList(fromIndex, toIndex)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(returnElements));
        return returnElements;
    }

    int[] getColumn(int columnNumber) {
        int size = elements.size();
        int[] returnElements = IntStream.range(0, size)
                .filter(i -> (i + 1)  % columns == 0)
                .mapToObj(i -> elements.get(i - (columns - columnNumber)))
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(returnElements));
        return returnElements;
    }
}
