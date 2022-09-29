package com.belyf;

public class PangramChecker {
    String alphabets = "abcdefghijklmnopqrstuvwxyz";
    public boolean isPangram(String input) {
        boolean flag = !alphabets.chars()
                .mapToObj(character -> Character.valueOf((char) character))
                .anyMatch(character -> input.toLowerCase().indexOf(character) == -1);
        return flag;
    }
}
