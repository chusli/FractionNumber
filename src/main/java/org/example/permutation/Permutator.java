package org.example.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutator {
    public static List<List<Integer>> permute(List<Integer> eingabe) {

        List<List<Integer>> list = new ArrayList<>();
        var factorial = Factorial.of(eingabe.size());
        if (eingabe.isEmpty()) {
            return list;
        }

        do {
            var random = new ArrayList<>(eingabe);
            Collections.shuffle(random);
            if (!list.contains(random)) {
                list.add(random);
            }
        } while (list.size() < factorial);

        return list;
    }

    public static void main(String[] args) {
        System.out.println(permute(List.of(1, 2, 3, 4, 5)));
    }
}
