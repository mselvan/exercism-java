package com.belyf;

abstract class Fighter {

    boolean isVulnerable() {
        return false;
    }

    abstract int damagePoints(Fighter fighter);

}

class Warrior extends Fighter {

    @Override
    public String toString() {
        return String.format("Fighter is a %s", this.getClass().getSimpleName());
    }

    @Override
    int damagePoints(Fighter wizard) {
        return wizard.isVulnerable() ? 10 : 6;
    }
}

class Wizard extends Fighter {
    boolean vulnerable = true;
    @Override
    public String toString() {
        return String.format("Fighter is a %s", this.getClass().getSimpleName());
    }
    @Override
    boolean isVulnerable() {
        return vulnerable;
    }

    @Override
    int damagePoints(Fighter warrior) {
        return this.isVulnerable() ? 3 : 12;
    }

    void prepareSpell() {
        vulnerable = false;
    }

}
