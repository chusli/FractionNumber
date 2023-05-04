package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AddFractionTest {

    @Test
    void zeroPlusZero() {
        Integer sum = new Fraction(0).plus(new Fraction(0));

        Assertions.assertThat(sum).isZero();
    }

    @Test
    void nonZeroPlusZero() {
        Integer sum = new Fraction(2).plus(new Fraction(0));

        Assertions.assertThat(sum).isEqualTo(2);
    }

    @Test
    void nonZeroPlusNonZero() {
        Integer sum = new Fraction(2).plus(new Fraction(8));

        Assertions.assertThat(sum).isEqualTo(10);
    }

}
