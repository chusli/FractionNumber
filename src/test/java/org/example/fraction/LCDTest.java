package org.example.fraction;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LCDTest {


    private static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of(1, 2, 1),
                Arguments.of(1, 3, 1),
                Arguments.of(2, 4, 2),
                Arguments.of(10, 20, 2),
                Arguments.of(33, 66, 3),
                Arguments.of(11, 31, 1),
                Arguments.of(25, 125, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provide")
    void getLowestCommonDenominator(int number1, int number2, int expectedLCD) {
        assertThat(LCD.of(number1, number2)).isEqualTo(expectedLCD);
    }
}