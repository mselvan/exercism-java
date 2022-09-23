package com.belyf;

public class Hamming {

    private int hammingDistance = 0;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() == rightStrand.length()) {
            for (int i = 0; i < leftStrand.length(); i++) {
                if (leftStrand.charAt(i) != rightStrand.charAt(i)) hammingDistance++;
            }
        } else if (leftStrand.length() == 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.length() == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    public int getHammingDistance() {
        return hammingDistance;
    }

    public static void main(String[] args) {
        Hamming hamming = new Hamming("G", "T");
        System.out.println(hamming.getHammingDistance());
    }
}

