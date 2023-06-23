package org.example.fraction;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddFractionTest {

    @Test
    void zeroPlusZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(0));

        assertThat(sum).isEqualTo(new Fraction(0));
    }

    @Test
    void nonZeroPlusZero() {
        Fraction sum = new Fraction(2).plus(new Fraction(0));

        assertThat(sum).isEqualTo(new Fraction(2));
    }

    @Test
    void nonZeroPlusNonZero() {
        Fraction sum = new Fraction(2).plus(new Fraction(8));

        assertThat(sum).isEqualTo(new Fraction(10));
    }

    @Test
    void whenDenominatorAndQuotientAreSameThenEqualToOne() {
        assertThat(new Fraction(5, 5)).isEqualTo(new Fraction(1));
    }

    @Test
    void multiplesAreEqual() {
        assertThat(new Fraction(5, 25)).isEqualTo(new Fraction(1, 5));
    }

    @Test
    void twoThirdsPlusOneThirdEqualsOne() {
        assertThat(new Fraction(2, 3).plus(new Fraction(1, 3)))
                .isEqualTo(new Fraction(1));
    }

    @Test
    void twoThirdsPlusTwoSixthsEqualsOne() {
        assertThat(new Fraction(2, 3).plus(new Fraction(2, 6)))
                .isEqualTo(new Fraction(1));
    }
}
