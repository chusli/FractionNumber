package org.example;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Fraction {
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator must not be equal to 0 (zero)");
        }
        this.numerator = numerator;
        this.denominator = denominator;

        Integer[] numeratorPrimeFactors = PrimeFactor.get(numerator);
        Integer[] denominatorPrimeFactors = PrimeFactor.get(denominator);

        for (int i = 0; i < numeratorPrimeFactors.length; i++) {
            final int temp = i;
            var indexOfDenominator = Arrays.stream(denominatorPrimeFactors).toList().indexOf(numeratorPrimeFactors[temp]);
            if (indexOfDenominator != -1) {
                var primeFactor = denominatorPrimeFactors[indexOfDenominator];
                this.numerator /= primeFactor;
                this.denominator /= primeFactor;
                denominatorPrimeFactors = Arrays.stream(denominatorPrimeFactors)
                        .filter(integer -> integer == primeFactor).toArray(Integer[]::new);
            }
        }
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
