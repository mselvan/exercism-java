package com.belyf;

public class Lasagna {
    private final int EXPECTED_MINUTES = 40;

    public int expectedMinutesInOven() {
        return EXPECTED_MINUTES;
    }
    public int remainingMinutesInOven(int minutesPassed) {
        return EXPECTED_MINUTES - minutesPassed;
    }
    public int preparationTimeInMinutes(int layers) {
        return layers * 2;
    }
    public int totalTimeInMinutes(int layers, int minutesPassed) {
        return preparationTimeInMinutes(layers) + minutesPassed;
    }

    public static void main(String[] args) {
        Lasagna lasagna = new Lasagna();
        System.out.println(lasagna.totalTimeInMinutes(3, 20));
    }
}
