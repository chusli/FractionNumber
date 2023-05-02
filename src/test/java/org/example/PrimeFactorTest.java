package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeFactorTest {
    @Test
    void get() {
        Integer[] sut = PrimeFactor.get(36);

        assertThat(sut).isEqualTo(new Integer[]{2, 2, 3, 3});
    }
}