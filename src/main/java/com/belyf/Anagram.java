package com.belyf;

import java.util.List;
import java.util.stream.Collectors;

public class Anagram {
    private final String word;

    public Anagram(String word) {
        this.word = word.toLowerCase();
    }

    public List<String> match(List<String> list) {
        List<String> anagrams = list.stream()
                .filter(str -> isAnagram(word, str.toLowerCase()))
                .collect(Collectors.toList());
        return anagrams;
    }

    private boolean isAnagram(String first, String second) {
        if(first.equals(second)) return false;
        String firstSorted = first.chars()
                .sorted()
                .mapToObj(integer -> Character.valueOf((char) integer).toString())
                .collect(Collectors.joining());
        String secondSorted = second.chars()
                .sorted()
                .mapToObj(integer -> Character.valueOf((char) integer).toString())
                .collect(Collectors.joining());
        System.out.println(firstSorted);
        System.out.println(secondSorted);
        return firstSorted.equals(secondSorted);
    }
}
