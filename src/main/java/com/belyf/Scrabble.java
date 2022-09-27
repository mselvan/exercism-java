package com.belyf;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

class Scrabble {
    private int score = 0;
    private final Map<Integer, String> SCORE_MAP = Map.ofEntries(
            Map.entry(1, "aeioulnrst"),
            Map.entry(2, "dg"),
            Map.entry(3, "bcmp"),
            Map.entry(4, "fhvwy"),
            Map.entry(5, "k"),
            Map.entry(8, "jx"),
            Map.entry(10, "qz")
    );

    private final Map<Character, Integer> SCORE_CHAR_MAP = SCORE_MAP.entrySet()
            .stream()
            .flatMap(entry -> entry.getValue().chars().mapToObj(charInt -> {
                Character ch = (char) charInt;
                Map.Entry<Character,Integer>  charEntry = new AbstractMap.SimpleEntry<Character, Integer>(ch, entry.getKey());
                return charEntry;
            })).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    Scrabble(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            score += SCORE_CHAR_MAP.get(c);
        }
    }

    int getScore() {
        return score;
    }

}
