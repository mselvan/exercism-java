package com.belyf;

import java.util.Map;

public class RaindropConverter {
    private int THREE = 3;
    private int FIVE = 5;
    private int SEVEN = 7;
    private Map<Integer, String> MAP = Map.ofEntries(
            Map.entry(THREE, "Pling"),
            Map.entry(FIVE, "Plang"),
            Map.entry(SEVEN, "Plong")
    );
    String convert(int number) {
        StringBuilder builder = new StringBuilder();
        if (number % THREE == 0) {
            builder.append(MAP.get(THREE));
        }
        if (number % FIVE == 0) {
            builder.append(MAP.get(FIVE));
        }
        if (number % SEVEN == 0) {
            builder.append(MAP.get(SEVEN));
        }
        String sound = builder.length() > 0 ? builder.toString() : String.valueOf(number);
        return sound;
    }
}
