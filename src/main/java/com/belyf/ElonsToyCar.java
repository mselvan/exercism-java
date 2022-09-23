package com.belyf;

public class ElonsToyCar {
    private int distanceDriven = 0;
    private int remainingBattery = 100;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", distanceDriven);
    }

    public String batteryDisplay() {
        String formatedString = remainingBattery > 0 ? String.format("Battery at %d%%", remainingBattery) : "Battery empty";
        return formatedString;
    }

    public void drive() {
        if(remainingBattery > 0) {
            distanceDriven += 20;
            remainingBattery -= 1;
        }
    }

    public static void main(String[] args) {
        ElonsToyCar toyCar = ElonsToyCar.buy();
        toyCar.drive();
        toyCar.drive();
        toyCar.drive();
        toyCar.drive();
        System.out.println(toyCar.distanceDisplay());
        System.out.println(toyCar.batteryDisplay());
    }
}
