package org.example.fraction;

import java.util.Objects;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator) {
        this.numerator = numerator;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction plus(Fraction that) {
        var newDenominator = denominator * that.denominator;
        var newNumerator = numerator * that.denominator + denominator * that.numerator;

        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        Fraction fraction = (Fraction) that;
        return numerator == fraction.numerator && denominator == fraction.denominator
                || numerator * fraction.denominator == denominator * fraction.numerator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }


    public String display() {
        int _numerator = numerator;
        int _denominator = denominator;
        int lcd = LCD.of(numerator, denominator);
        do {
            _numerator /= lcd;
            _denominator /= lcd;
            lcd = LCD.of(_numerator, _denominator);
        } while (lcd > 1);

        return _numerator + "/" + _denominator;
    }
}
