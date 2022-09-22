package com.belyf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsogramChecker {
    boolean isIsogram(String phrase) {
        Pattern pattern = Pattern.compile("(\\w).*\\1");
        Matcher matcher = pattern.matcher(phrase.toLowerCase());
        return !matcher.find();
    }

    public static void main(String[] args) {
        IsogramChecker isogramChecker = new IsogramChecker();
        System.out.println(isogramChecker.isIsogram("isograms"));;
    }
}
