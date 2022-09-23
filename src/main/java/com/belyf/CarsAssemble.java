package com.belyf;
import java.math.BigDecimal;
import java.util.Map;

public class CarsAssemble {

    private final int CARS_PER_HOUR = 221;
    private final Map<Integer, Integer> ACCURACY = Map.ofEntries(
            Map.entry(0, 0),
            Map.entry(1, 100),
            Map.entry(2, 100),
            Map.entry(3, 100),
            Map.entry(4, 100),
            Map.entry(5, 90),
            Map.entry(6, 90),
            Map.entry(7, 90),
            Map.entry(8, 90),
            Map.entry(9, 80),
            Map.entry(10, 77)
    ) ;

    public double productionRatePerHour(int speed) {
        Double actualCarsPerHour = speed * CARS_PER_HOUR * ACCURACY.get(speed) * 0.01;
        return BigDecimal.valueOf(actualCarsPerHour).doubleValue();
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }

    public static void main(String[] args) {
        CarsAssemble carsAssemble = new CarsAssemble();
        System.out.println(carsAssemble.productionRatePerHour(10));
    }
}
