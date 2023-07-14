package org.example.permutation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FactorialTest {

    private static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.arguments(0, 1L),
                Arguments.arguments(1, 1L),
                Arguments.arguments(2, 2L),
                Arguments.arguments(3, 6L),
                Arguments.arguments(4, 24L),
                Arguments.arguments(5, 120L),
                Arguments.arguments(13, 6_227_020_800L),
                Arguments.arguments(20, 2_432_902_008_176_640_000L)
        );
    }

    @ParameterizedTest
    @MethodSource("provide")
    void name(Integer input, long expectedFactorial) {
        assertThat(Factorial.of(input)).isEqualTo(expectedFactorial);
    }
}
