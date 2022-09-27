package com.belyf;

class NeedForSpeed {
    private int batteryDrain;
    private int speed;
    private int distanceDriven = 0;
    private int batteryPercentage = 100;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return batteryPercentage == 0;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        if(batteryPercentage > 0) {
            this.distanceDriven += speed;
            this.batteryPercentage -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private final int distance;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        while(car.distanceDriven() < distance) {
            if(car.batteryDrained()) {
                return false;
            } else {
                car.drive();
            }
        }
        return true;
    }
}
