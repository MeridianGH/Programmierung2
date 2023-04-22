package edu.htwk.romacker;

public class Main {
    public static void main(String[] args) {
        Fraction a = new Fraction(2, 5);
        System.out.println(a);
        System.out.println(a.toMixedString());

        Fraction b = new Fraction(3, 5);
        System.out.println(a.subtract(b));
    }
}
