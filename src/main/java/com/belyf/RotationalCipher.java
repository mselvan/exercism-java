package com.belyf;

import java.util.stream.Collectors;

public class RotationalCipher {

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    char encryptChar(int ch) {
        if(!Character.isLetter(ch)) {
            return (char) ch;
        }
        char start = Character.isUpperCase(ch) ? 'A' : 'a';
        return (char) (start + (ch + shiftKey - start) % 26);
    }

    String rotate(String data) {
        return data.chars()
                .mapToObj(this::encryptChar)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
