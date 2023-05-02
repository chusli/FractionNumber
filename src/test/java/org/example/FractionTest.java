package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FractionTest {

    @Test
    void validFraction() {
        Fraction sut = new Fraction(1, 1);
    }

    @Test
    void denominatorZeroThrows() {
        assertThrows(IllegalArgumentException.class,
                () ->new Fraction(1, 0));
    }

    @Test
    void toStringTest() {
        var sut = new Fraction(1, 5);

        assertThat(sut.toString()).isEqualTo("1/5");
    }

    @Test
    void equalsTest() {
        var sut = new Fraction(2, 4);
        var expected =  new Fraction(2, 4);

        assertThat(sut).isEqualTo(expected);
    }

    @Test
    void reducedFractionIsEqual() {
        var sut = new Fraction(2, 4);
        var expected =  new Fraction(1, 2);

        assertThat(sut).isEqualTo(expected);
    }
}