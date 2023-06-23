package org.example.fraction;

import java.util.List;

public class LCD {
    public static int of(int number1, int number2) {
        List<Integer> factors = Prime.getPrimeFactors(number1);
        List<Integer> factors2 = Prime.getPrimeFactors(number2);

        return factors.stream().filter(factors2::contains)
                .findFirst()
                .orElse(1);
    }


}
