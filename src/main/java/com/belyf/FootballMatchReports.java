package com.belyf;

import java.util.Map;

public class FootballMatchReports {
    private static Map<Integer, String> SHIRT_NUMBER_MAPPING = Map.ofEntries(
        Map.entry(1, "goalie"),
        Map.entry(2, "left back"),
        Map.entry(3, "center back"),
        Map.entry(4, "center back"),
        Map.entry(5, "right back"),
        Map.entry(6, "midfielder"),
        Map.entry(7, "midfielder"),
        Map.entry(8, "midfielder"),
        Map.entry(9, "left wing"),
        Map.entry(10, "striker"),
        Map.entry(11, "right wing")
    );
    public static String onField(int shirtNum) {
        if(SHIRT_NUMBER_MAPPING.containsKey(shirtNum)) {
            return SHIRT_NUMBER_MAPPING.get(shirtNum);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
