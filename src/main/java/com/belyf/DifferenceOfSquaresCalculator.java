package com.belyf;

public class DifferenceOfSquaresCalculator {
    int computeSquareOfSumTo(int input) {
        int sum = 0;
        for (int i = 1; i <= input; i++) {
            sum += i;
        }
        return (sum * sum);
    }

    int computeSumOfSquaresTo(int input) {
        int sumOfSquare = 0;
        for (int i = 1; i <= input; i++) {
            sumOfSquare += (i * i);
        }
        return sumOfSquare;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }
}
