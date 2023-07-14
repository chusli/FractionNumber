package org.example.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutator {
    public static List<List<Integer>> permute(List<Integer> eingabe) {

        List<List<Integer>> list = new ArrayList<>();

        if (eingabe.isEmpty()) {
            return list;
        }

        list.add(eingabe);

        return list;
    }
}
