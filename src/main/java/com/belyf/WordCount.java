package com.belyf;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCount {
    public Map<String, Integer> phrase(String phraseInput) {
        Pattern wordsOrWordsWithApostrophesPattern = Pattern.compile("(\\w+\\w'\\w|\\w+)");
        return wordsOrWordsWithApostrophesPattern.matcher(phraseInput).results()
                .map(m -> m.group())
                .map(String::toLowerCase)
                .collect(
                        Collectors.groupingBy(
                                word -> word,
                                Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                        )
                );
    }
}
