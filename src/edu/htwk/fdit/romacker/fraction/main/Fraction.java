package edu.htwk.fdit.romacker.fraction.main;

import java.math.BigInteger;

public class Fraction implements Comparable {

    private final int numerator;
    private final int denominator;
    private final int sign;

    public Fraction(int num) {
        this.numerator = Math.abs(num);
        this.denominator = 1;
        if (this.numerator == 0) {
            this.sign = 0;
        } else {
            this.sign = num < 0 ? -1 : 1;
        }
    }

    public Fraction(int num, int den) {

        this.numerator = Math.abs(num);
        this.denominator = Math.abs(den);

        if(this.numerator == 0) {
            this.sign = 0;
        } else {
            this.sign = (num * den < 0) ? -1 : 1;
        }
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public Fraction add(Fraction addend) {
        int myNewNum = this.sign * this.numerator * addend.denominator;
        int theirNewNum = addend.sign * addend.numerator * this.denominator;
        int commonDenominator = this.denominator * addend.denominator;

        return new Fraction(myNewNum + theirNewNum, commonDenominator);
    }

    public Fraction sub(Fraction subtrahend) {
        return this.add(subtrahend.multiplyWith(-1));
    }

    public Fraction multiplyWith(Fraction multiplicand) {
        int theNewNum = this.sign * this.numerator * multiplicand.sign * multiplicand.numerator;
        int theNewDen = this.denominator * multiplicand.denominator;
        return new Fraction(theNewNum, theNewDen);
    }

    public Fraction multiplyWith(Integer multiplicand) {
        return new Fraction(this.numerator * multiplicand, this.denominator);
    }

    public Fraction divideBy(Fraction divisor) {
        return this.multiplyWith(divisor.reciprocal());
    }

    public Fraction divideBy(Integer divisor) {
        return this.multiplyWith(new Fraction(1, divisor));
    }

    public Fraction reciprocal() {
        return new Fraction(this.sign * this.denominator, this.numerator);
    }

    public Fraction reduced() {
        BigInteger n = BigInteger.valueOf(this.numerator);
        BigInteger d = BigInteger.valueOf(this.denominator);
        int gcd = n.gcd(d).intValue();

        return new Fraction(this.sign * (this.numerator / gcd), this.denominator / gcd);
    }

    public boolean isPositive() {
        return this.sign > 0;
    }

    public boolean isNegative() {
        return this.sign < 0;
    }

    @Override
    public String toString() {
        return "Fraction@" + this.hashCode() + "[" + this.sign + "*" + this.numerator + "/" + this.denominator + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj instanceof Fraction fraction) {
            boolean hasSameNumerator = fraction.reduced().getNumerator() == this.reduced().numerator;
            boolean hasSameDenominator = fraction.reduced().getDenominator() == this.reduced().denominator;
            boolean hasSameSign = fraction.sign == this.sign;

            return hasSameNumerator && hasSameDenominator && hasSameSign;
        }
        if (obj instanceof Number) {
            double f = (this.sign * (double) this.numerator) / this.denominator;
            System.out.println("Float:");
            System.out.println(f);
            System.out.println("Object:");
            System.out.println(Double.parseDouble(obj.toString()));
            return f == Double.parseDouble(obj.toString());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        result = 31 * result + sign;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) { throw new NullPointerException("Cannot compare with 'null'."); }
        if (o instanceof Fraction fraction) {
            Fraction a = this.multiplyWith(fraction.denominator);
            Fraction b = fraction.multiplyWith(this.denominator);
            return Integer.compare(a.getNumerator(), b.getNumerator());
        }
        return 0;
    }
}
