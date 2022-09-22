package com.belyf;

class ReverseString {
    String reverse(String inputString) {
        return new StringBuilder().append(inputString).reverse().toString();
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverse("Hello"));
    }
}
