package org.example.fraction;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeTest {
    @Test
    void name() {
        assertThat(Prime.of(5).isPrime()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 23})
    void arePrime(int number) {
        assertThat(Prime.of(number).isPrime()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 14, 21, 44, 100, 1000})
    void areNotPrime(int number) {
        assertThat(Prime.of(number).isPrime()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(longs = {
            2385210343L,
            8394832932631L,
            73508660322257L,
            2068078282201469L,
            6598559483747757761L
    })
    void performance(long number) {
        long start = System.currentTimeMillis();
        Prime.of(number).isPrime();
        long slow = System.currentTimeMillis() - start;
        Prime.of(number).isPrime();
        long fast = System.currentTimeMillis() - start - slow;
        assertThat(fast).isLessThan(slow);
    }

    @Test
    void getPrimeFactors() {
        List<Integer> factors = Prime.getPrimeFactors(2310);
        assertThat(factors).containsExactly(2, 3, 5, 7, 11);
    }
}
