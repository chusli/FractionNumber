package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AddFractionTest {

    @Test
    void zeroPlusZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(0));

        Assertions.assertThat(sum).isEqualTo(new Fraction(0));
    }

    @Test
    void nonZeroPlusZero() {
        Fraction sum = new Fraction(2).plus(new Fraction(0));

        Assertions.assertThat(sum).isEqualTo(new Fraction(2));
    }

    @Test
    void nonZeroPlusNonZero() {
        Fraction sum = new Fraction(2).plus(new Fraction(8));

        Assertions.assertThat(sum).isEqualTo(new Fraction(10));
    }

}
