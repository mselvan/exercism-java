package com.belyf;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class MicroBlog {
    public String truncate(String input) {
        Optional<String> result = Pattern.compile(".{1,5}")
                .matcher(new String(input.getBytes(), StandardCharsets.UTF_8))
                .results()
                .map(MatchResult::group)
                .findFirst();

        return result.isPresent() ? result.get() : "";
    }

    public static void main(String[] args) {
        MicroBlog mb = new MicroBlog();
        System.out.println(mb.truncate("abqweqwe"));;
    }
}
