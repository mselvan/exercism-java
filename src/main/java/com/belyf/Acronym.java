package com.belyf;

import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {

    private final String acronym;

    Acronym(String phrase) {
        phrase = phrase
                .chars()
                .mapToObj(value -> Character.valueOf((char) value))
                .filter(value -> Character.isLetter(value) || Character.isSpaceChar(value) || value == '-')
                .map(value -> value.toString())
                .collect(Collectors.joining());
        phrase = phrase.replaceAll("-", " ");
        this.acronym = Arrays.stream(phrase.split(" "))
                .filter(s -> s.length() > 0)
                .map(firstChar -> String.valueOf(firstChar.charAt(0)).toUpperCase())
                .collect(Collectors.joining());
    }

    String get() {
        return acronym;
    }

}
