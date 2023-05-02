package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

    private static int[] primeNumbers = {2, 3, 5, 7};
    public static Integer[] get(int number) {
        List<Integer> list = new ArrayList<>();

        int indexOfPrimeNumber = 0;

        while (primeNumbers[indexOfPrimeNumber] <= number) {
            if (number % primeNumbers[indexOfPrimeNumber] == 0) {
                number /= primeNumbers[indexOfPrimeNumber];
                list.add(primeNumbers[indexOfPrimeNumber]);
            } else {
                indexOfPrimeNumber++;
            }
        }
        return list.toArray(Integer[]::new);
    }
}
