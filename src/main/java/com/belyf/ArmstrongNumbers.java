package com.belyf;

public class ArmstrongNumbers {

    public boolean isArmstrongNumber(int number) {
        int sourceNumber = number;
        int length = (int) (Math.log10(sourceNumber) + 1);
        int targetNumber = 0;
        while (number > 0) {
            targetNumber += Math.pow(number % 10, length);
            number = number / 10;
        }
        return sourceNumber == targetNumber;
    }
}
