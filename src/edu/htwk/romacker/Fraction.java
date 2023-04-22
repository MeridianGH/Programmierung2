package edu.htwk.romacker;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction addend) {
        this.numerator = this.numerator * addend.denominator + addend.numerator * this.denominator;
        this.denominator *= addend.denominator;
        this.reduce();
        return this;
    }

    public static Fraction add(Fraction a, Fraction b) {
        return new Fraction(a.numerator, a.denominator).add(b);
    }

    public Fraction subtract(Fraction subtrahend) {
        this.numerator = this.numerator * subtrahend.denominator - subtrahend.numerator * this.denominator;
        this.denominator *= subtrahend.denominator;
        this.reduce();
        return this;
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        return new Fraction(a.numerator, a.denominator).subtract(b);
    }

    public Fraction multiply(Fraction factor) {
        this.numerator *= factor.numerator;
        this.denominator *= factor.denominator;
        this.reduce();
        return this;
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        return new Fraction(a.numerator, a.denominator).multiply(b);
    }

    public Fraction divide(Fraction divisor) {
        this.numerator *= divisor.denominator;
        this.denominator *= divisor.numerator;
        // or this.multiply(this.reciprocal);
        this.reduce();
        return this;
    }

    public static Fraction divide(Fraction a, Fraction b) {
        return new Fraction(a.numerator, a.denominator).divide(b);
    }

    public Fraction reduce() {
        int gcd = Math.abs(calculateGCD(this.numerator, this.denominator));
        this.numerator /= gcd;
        this.denominator /= gcd;
        return this;
    }

    public Fraction reciprocal() {
        return new Fraction(this.denominator, this.numerator);
    }

    public String toMixedString() {
        int mod = this.numerator % this.denominator;
        if (mod == 0) { return String.valueOf(this.numerator / this.denominator); }
        return (this.numerator / this.denominator) + " " + mod + "/" + this.denominator;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    private int calculateGCD(int a, int b) {
        return b == 0 ? a : calculateGCD(b, a % b);
    }
}
