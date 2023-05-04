package org.example;

import java.util.Objects;

public class Fraction {
    private final int value;

    public Fraction(int value) {
        this.value = value;
    }

    public Fraction plus(Fraction that) {
        return new Fraction(this.value + that.value);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Fraction fraction = (Fraction) that;
        return value == fraction.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
