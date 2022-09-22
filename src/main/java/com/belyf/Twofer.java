package com.belyf;

public class Twofer {
    public String twofer(String name) {
        return String.format("One for %s, one for me.", name != null && !"".equals(name.trim()) ? name: "you" );
    }
}
