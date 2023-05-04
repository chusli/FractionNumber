package org.example;

public class Fraction {

    private final int value;

    public Fraction(int value) {
        this.value = value;
    }

    public Integer plus(Fraction that) {
        return this.value + that.value;
    }
}
