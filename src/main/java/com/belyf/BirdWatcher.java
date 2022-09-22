package com.belyf;

import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        return birdsPerDay.length > 0 ? birdsPerDay[birdsPerDay.length - 1] : 0;
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1] = birdsPerDay[birdsPerDay.length - 1] + 1;
    }

    public boolean hasDayWithoutBirds() {
        return Arrays.stream(birdsPerDay).anyMatch(value -> value == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        return Arrays.stream(birdsPerDay).limit(numberOfDays).sum();
    }

    public int getBusyDays() {
        return (int) Arrays.stream(birdsPerDay).filter(value -> value >= 5).count();
    }

    public static void main(String[] args) {
        BirdWatcher birdWatcher = new BirdWatcher(new int[] { 1, 2, 5, 3, 7, 8, 4 });
        birdWatcher.incrementTodaysCount();
        System.out.println(birdWatcher.getCountForFirstDays(10));
    }
}

