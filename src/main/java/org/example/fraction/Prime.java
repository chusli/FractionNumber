package org.example.fraction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.lang.Math.sqrt;

public class Prime {
    private static final Map<Long, Boolean> primeNumbers = new HashMap<>();
    private final long number;

    private Prime(long number) {
        this.number = number;
    }

    public static Prime of(long i) {
        return new Prime(i);
    }

    public static List<Integer> getPrimeFactors(int number1) {
        return IntStream.rangeClosed(1, number1)
                .filter(value -> Prime.of(value).isPrime() && number1 % value == 0)
                .boxed()
                .toList();
    }

    public boolean isPrime() {
        if (number == 1) {
            return false;
        }
        if (primeNumbers.containsKey(number)) {
            return primeNumbers.get(number);
        }
        long limit = number > 10 ? (int) Math.ceil(sqrt(number)) : number;
        for (long i = 2; i < limit; i++) {
            if (number % i == 0) {
                primeNumbers.put(number, false);
                return false;
            }
        }
        primeNumbers.put(number, true);
        return true;
    }
}
