package org.example;

import org.example.fraction.Fraction;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Fraction result = enterFraction().plus(enterFraction());
        System.out.println(result.display());
    }

    private static Fraction enterFraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter two numbers for fraction");
        Fraction fraction = new Fraction(scanner.nextInt(), scanner.nextInt());
        System.out.println("fraction is " + fraction.display());
        return fraction;
    }
}
