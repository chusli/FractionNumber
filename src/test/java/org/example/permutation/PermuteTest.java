package org.example.permutation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PermuteTest {

    @Test
    @DisplayName("Dieser Test steht für RIGHT in RIGHT BICEP")
    void happyCaseTest() {
        // arrange
        List<Integer> eingabe = List.of(1, 2);

        // act
        List<List<Integer>> actual = Permutator.permute(eingabe);

        // assert
        List<List<Integer>> expected = List.of(List.of(1, 2), List.of(2, 1));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Dieser Test steht für das B in RIGHT BICEP")
    void boundaryTests() {
        // arrange test cases for CORRECT
        List<Integer> conformFormat = List.of(1); //
        List<Integer> order = List.of(1);
        List<Integer> range = List.of(1);
        List<Integer> reference = List.of(1);
        List<Integer> existence = List.of(1);
        List<Integer> cardinality = List.of(1);
        List<Integer> time = List.of(1);

        // act + assert
        assertThrows(BoundaryException.class, () -> Permutator.permute(conformFormat));
        assertThrows(BoundaryException.class, () -> Permutator.permute(order));
        assertThrows(BoundaryException.class, () -> Permutator.permute(range));
        assertThrows(BoundaryException.class, () -> Permutator.permute(reference));
        assertThrows(BoundaryException.class, () -> Permutator.permute(existence));
        assertThrows(BoundaryException.class, () -> Permutator.permute(cardinality));
        assertThrows(BoundaryException.class, () -> Permutator.permute(time));
    }

    @Test
    @DisplayName("Dieser Test steht für das I in RIGHT BICEP")
    void inverseTest() {
        // arrange
        List<Integer> eingabe = List.of(1, 2);

        // act
        // jede liste sollte das gleiche Resultat ergeben, wenn erneut permutiert wird
        List<List<Integer>> permutationen = Permutator.permute(eingabe);
        List<List<List<Integer>>> actual = permutationen.stream().map(Permutator::permute).toList();

        // assert
        actual.forEach(list -> assertThat(list).containsExactlyElementsOf(permutationen));
    }

    @Test
    @DisplayName("Dieser Test steht für das C in RIGHT BICEP")
    void crossCheckTest() {
        List<Integer> eingabe = List.of(1, 2);

        List<List<Integer>> actual = Permutator.permute(eingabe);

        // assert durch viele Checks mit zufälliger Permutation
        ArrayList<Integer> expected = new java.util.ArrayList<>(List.of(1, 2));
        for (int i = 0; i < 1000; i++) {
            Collections.shuffle(expected);
            assertThat(actual).contains(expected);
        }
    }

    @Test
    @DisplayName("Dieser Test steht für das E in RIGHT BICEP")
    void errorTest() {
        // arrange
        List<Integer> eingabe = IntStream.rangeClosed(0, 2147483647).boxed().toList();

        // act + assert
        assertThrows(OutOfMemoryError.class, () -> Permutator.permute(eingabe));
    }

    @Test
    @DisplayName("Dieser Test steht für das P in RIGHT BICEP")
    void performanceSingleTest() {
        // arrange
        List<Integer> eingabe = IntStream.rangeClosed(0, 99999).boxed().toList();

        // act und Zeitmessen
        long dauer = zeitmessen(eingabe);

        // assert
        // da dieser Test etwas flacky sein kann, muss man sich gut überlegen diesen so zu deployen
        assertThat(dauer).isLessThan(42L);
    }

    @Test
    @DisplayName("Dieser Test steht für das P in RIGHT BICEP")
    void performanceManyTest() {
        // arrange
        final int sampleSize = 1000;
        List<Integer> eingabe = IntStream.rangeClosed(0, 99999).boxed().toList();

        // act und Zeitmessen über mehrere Testläufe
        long timetaken = 0;
        for (int i = 0; i < sampleSize; i++) {
            timetaken += zeitmessen(eingabe);
        }

        // assert der durchschnittlichen Runtime
        // hier wäre interessant mit Varianz/Standardabweichung das Resultat etwas genauer zu analysieren
        // zudem müsste man sich überlegen diesen Test nur einmal pro Tag/Build/Release auszuführen
        assertThat(timetaken / sampleSize).isLessThan(42L);
    }

    private long zeitmessen(List<Integer> eingabe) {
        long start = System.nanoTime();
        Permutator.permute(eingabe);
        return System.nanoTime() - start;
    }
}
