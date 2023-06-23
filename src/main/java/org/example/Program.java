package org.example;

import org.example.fraction.Fraction;

public class Program {
    public static void main(String[] args) {
        Fraction result = new Fraction(5).plus(new Fraction(2));
        System.out.println(result);
    }
}
