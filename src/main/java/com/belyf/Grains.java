package com.belyf;

import java.math.BigInteger;

public class Grains {
    private final BigInteger TWO = BigInteger.valueOf(2);

    BigInteger grainsOnSquare(final int square) {
        if(square > 64 || square < 1) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        BigInteger grainsOnSquare = BigInteger.valueOf(1);
        for (int i = 2; i <= square; i++) {
            grainsOnSquare = grainsOnSquare.multiply(TWO);
        }
        return grainsOnSquare;
    }

    BigInteger grainsOnBoard() {
        BigInteger grainsOnSquare = BigInteger.valueOf(1);
        BigInteger totalGrains = grainsOnSquare;
        for (int i = 2; i <= 64; i++) {
            grainsOnSquare = grainsOnSquare.multiply(TWO);
            totalGrains = totalGrains.add(grainsOnSquare);
        }
        return totalGrains;
    }
}
