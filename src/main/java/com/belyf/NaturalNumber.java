package com.belyf;

public class NaturalNumber {

    final Classification classification;
    public NaturalNumber(int number) {
        if(number < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        int aliquotSum = 0;
        for (int i = 1; i <= number/2; i++) {
            aliquotSum += number % i == 0 ? i : 0;
        }
        classification = aliquotSum == number ? Classification.PERFECT : aliquotSum > number ? Classification.ABUNDANT : Classification.DEFICIENT;
    }

    public Classification getClassification() {
        return classification;
    }
}

enum Classification {
    PERFECT, ABUNDANT, DEFICIENT
}
