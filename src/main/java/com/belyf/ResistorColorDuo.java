package com.belyf;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ResistorColorDuo {
    String [] allColors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    int value(String[] colorCodes) {
        String code = Arrays.stream(colorCodes)
                .mapToInt(colorCode -> {
                    AtomicInteger i = new AtomicInteger();
                    int index = Arrays.stream(allColors)
                            .peek(v -> i.incrementAndGet())
                            .anyMatch(color -> colorCode.equals(color)) ?
                            i.get() - 1 : -1;
                    return index;
                }).limit(2).mapToObj(value -> String.valueOf(value)).collect(Collectors.joining(""));
        return Integer.parseInt(code);
    }
}
