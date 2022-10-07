package com.belyf;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Robot {
    private static final int CHAR_GENERATE_LENGTH = 2;
    private static final int NUMBER_GENERATE_LENGTH = 3;
    private static final int MIN_CHAR = 'A';
    private static final int MAX_CHAR = 'Z';
    private static final int MIN_NUMBER = '0';
    private static final int MAX_NUMBER = '9';

    private String name;
    public Robot() {
        reset();
    }

    private static Set<String> usedNames = new HashSet<>();

    private static Function<GenerateSpec, String> generateRandomPart = spec -> new Random()
                                                                                    .ints(spec.min, spec.max)
                                                                                    .limit(spec.length)
                                                                                    .mapToObj( i -> String.valueOf((char) i))
                                                                                    .collect(Collectors.joining(""));
    private static Supplier<String> namesSupplier = () -> generateRandomPart.apply(new GenerateSpec(MIN_CHAR, MAX_CHAR, CHAR_GENERATE_LENGTH)) + generateRandomPart.apply(new GenerateSpec(MIN_NUMBER, MAX_NUMBER, NUMBER_GENERATE_LENGTH));

    public String getName() {
        return this.name;
    }

    public void reset() {
        this.name = Stream.generate(namesSupplier)
                .filter(name -> !usedNames.contains(name) && usedNames.add(name))
                .findFirst()
                .get();
    }

}

class GenerateSpec {
    int min;
    int max;
    int length;

    public GenerateSpec(int min, int max, int length) {
        this.min = min;
        this.max = max;
        this.length = length;
    }
}