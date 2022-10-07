package com.belyf;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flattener {

    private Stream<?> flattenToStream(Object element) {
        return element instanceof List ? ((List)element).stream().flatMap(this::flattenToStream) : Stream.of(element);
    }
    public List<?> flatten(List<?> list) {
        List<?> flattenedList = flattenToStream(list)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return flattenedList;
    }
}
