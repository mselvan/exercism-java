package com.belyf;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ResistorColor {
    String [] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    int colorCode(String color) {
        AtomicInteger i = new AtomicInteger(); // any mutable integer wrapper
        int index = Arrays.stream(colors)
                .peek(v -> i.incrementAndGet())
                .anyMatch(c -> color.equals(c)) ? // your predicate
                i.get() - 1 : -1;
        return index;
    }

    String[] colors() {
        return colors;
    }
}
