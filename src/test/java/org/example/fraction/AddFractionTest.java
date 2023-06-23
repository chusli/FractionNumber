package org.example.fraction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AddFractionTest {

    private static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of(1, 2, "1/2"),
                Arguments.of(10, 20, "1/2"),
                Arguments.of(3, 9, "1/3"),
                Arguments.of(2, 6, "1/3"),
                Arguments.of(15, 45, "1/3"),
                Arguments.of(20, 88, "5/22"),
                Arguments.of(9, 8, "9/8"),
                Arguments.of(0, 20, "0/1")
        );
    }

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

    @Test
    void oneHalfPlusFiveEigthsEqualsNineEigths() {
        assertThat(new Fraction(1, 2).plus(new Fraction(5, 8)))
                .isEqualTo(new Fraction(9, 8));
    }

    @ParameterizedTest
    @MethodSource("provide")
    void outputIsAlwaysReduced(int numerator, int denominator, String expected) {
        assertThat(new Fraction(numerator, denominator).display()).isEqualTo(expected);
    }

}
