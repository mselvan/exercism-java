package com.belyf.remotecar;

public class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private int numberOfVictories;
    private int distanceTravelled;

    @Override
    public void drive() {
        distanceTravelled += 10;
    }

    @Override
    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getNumberOfVictories() {
        return this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberofVictories) {
        this.numberOfVictories = numberofVictories;
    }
    @Override
    public int compareTo(ProductionRemoteControlCar other) {
        return this.getNumberOfVictories() - other.getNumberOfVictories();
    }
}
