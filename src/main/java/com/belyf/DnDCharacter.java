package com.belyf;

import java.util.Random;

class DnDCharacter {

    private Integer strengthScore;
    private Integer dexterityScore;
    private Integer constitutionScore;
    private Integer intelligenceScore;
    private Integer wisdomScore;
    private Integer charismaScore;
    private Integer hitPoints;

    public DnDCharacter() {
        strengthScore = ability();
        dexterityScore = ability();
        constitutionScore = ability();
        intelligenceScore = ability();
        wisdomScore = ability();
        charismaScore = ability();
        hitPoints = 10 + modifier(constitutionScore);
    }

    int rollDie(int numSides) {
        Random random = new Random();
        return random.nextInt(numSides) + 1;
    }

    int ability() {

        Integer sumOfAllRolls = 0;

        Integer rolls[] = {rollDie(6), rollDie(6), rollDie(6), rollDie(6)};

        Integer lowestRoll = rolls[0];
        for (Integer roll : rolls) {
            sumOfAllRolls += roll;
            if (roll < lowestRoll) {
                lowestRoll = roll;
            }
        }

        return sumOfAllRolls - lowestRoll;
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10 - (input % 2)) / 2);
    }

    int getStrength() {
        return strengthScore;
    }

    int getDexterity() {
        return dexterityScore;
    }

    int getConstitution() {
        return constitutionScore;
    }

    int getIntelligence() {
        return intelligenceScore;
    }

    int getWisdom() {
        return wisdomScore;
    }

    int getCharisma() {
        return charismaScore;
    }

    int getHitpoints() {
        return hitPoints;
    }

}