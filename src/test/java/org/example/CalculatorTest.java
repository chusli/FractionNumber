package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void acceptanceTest() {
        Calculator testee = new Calculator();
        Bruch bruch1 = new Bruch();
        Bruch bruch2 = new Bruch();
        testee.addFractions(bruch1, bruch2);
    }
}