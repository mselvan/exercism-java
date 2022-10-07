package com.belyf.saddle;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

class Matrix {

    List<Integer> columnMins;
    List<Integer> rowMaxs  = new ArrayList<>();
    List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;

        columnMins = range(0, values.size() > 0 ? values.get(0).size() : 0)
                .map(col -> values.stream().mapToInt(value -> value.get(col))
                        .min().orElseThrow()).boxed().collect(Collectors.toList());

        for (List<Integer> row : values) {
            rowMaxs.add(Collections.max(row));
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return range(0, values.size()).boxed()
                .flatMap(rowIndex -> range(0, values.get(0).size())
                        .filter(colIndex -> Objects.equals(rowMaxs.get(rowIndex), columnMins.get(colIndex)))
                        .mapToObj(columnIndex -> new MatrixCoordinate(rowIndex + 1, columnIndex + 1)))
                .collect(Collectors.toSet());
    }

}

