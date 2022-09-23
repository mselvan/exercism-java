package com.belyf;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PigLatinTranslator {

    static final Pattern WORDS_DELIMITER = Pattern.compile(" ");
    static final Pattern RULES = Pattern.compile("((?<vowelpart>([aeiou]|^x[^aeiouy]|^yt)(.*))|(?<consonantCluster>y?(?:[^aeiouy]*qu|[^aeiouy]*)))(?<rest>.*)");
    static final String  TEMPLATE = "${vowelpart}${rest}${consonantCluster}ay";

    private String translateWord(String word) {

        return RULES.matcher(word).replaceFirst(TEMPLATE);
    }

    public String translate(String phrase) {
        return WORDS_DELIMITER.splitAsStream(phrase)
                .map(this::translateWord)
                .collect(Collectors.joining(" "));
    }
}