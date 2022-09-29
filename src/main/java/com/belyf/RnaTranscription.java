package com.belyf;

import java.util.Map;
import java.util.stream.Collectors;

public class RnaTranscription {
    private final Map<Character, Character> DNA_MAPPING = Map.ofEntries(
        Map.entry('G', 'C'),
        Map.entry('C', 'G'),
        Map.entry('T', 'A'),
        Map.entry('A', 'U')
    );
    public String transcribe(String dnaStrand) {
        String transcribedString = dnaStrand.chars().mapToObj(value -> {
            Character actualChar = Character.valueOf((char) value);
            Character replacementChar = DNA_MAPPING.get(actualChar);
            return replacementChar.toString();
        }).collect(Collectors.joining());
        return transcribedString;
    }
}
