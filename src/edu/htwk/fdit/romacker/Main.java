package edu.htwk.fdit.romacker;

public class Main {
    public static void main(String[] args) {
        Fraction a = new Fraction(1, 4);
        Fraction b = new Fraction(2, 10);
        Fraction c = new Fraction(1, -3);

        // Basic arithmetic operations.

        System.out.println(a);
        System.out.println(b + ", " + b.reduce());
        Fraction d = Fraction.multiply(a, b.reciprocal());
        System.out.println(d + ", " + d.toMixedString());

        // Static methods.
        System.out.println(Fraction.add(a, b));

        // Most methods of Fraction allow for chaining:
        System.out.println(a.add(b).subtract(c).multiply(a).divide(b));
    }
}
