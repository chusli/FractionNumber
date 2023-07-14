package org.example.permutation;

import java.util.stream.IntStream;

public class Factorial {
    public static long of(Integer input) {
        if (input == 0) {
            return 1;
        }
        return IntStream.rangeClosed(1, input)
                .mapToObj(operand -> (long) operand)
                .reduce(1L, (left, right) -> left * right);
    }

}
