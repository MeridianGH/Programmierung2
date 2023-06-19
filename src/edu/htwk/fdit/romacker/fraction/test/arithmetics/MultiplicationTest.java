package edu.htwk.fdit.romacker.fraction.test.arithmetics;

import edu.htwk.fdit.romacker.fraction.main.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiplicationTest {

    @Test
    void whenMultiplyingTwoPositiveFractions_thenSolutionIsCorrect() {
        Fraction number = new Fraction(1,2);
        Fraction multiplicand = new Fraction(1,3);
        assertEquals(new Fraction(1,6), number.multiplyWith(multiplicand));
    }

    @Test
    void whenMultiplyingTwoNegativeFractions_thenSolutionIsCorrect() {
        Fraction number = new Fraction(-1, 2);
        Fraction multiplicand = new Fraction(-2, 4);
        assertEquals(new Fraction(2,8), number.multiplyWith(multiplicand));
    }

    @Test
    void whenMultiplyingNegativeFractionWithPositive_thenSolutionIsCorrect() {
        Fraction number = new Fraction(-1,2);
        Fraction multiplicand = new Fraction(2,4);
        assertEquals(new Fraction(-2,8), number.multiplyWith(multiplicand));
    }

    @Test
    void whenMultiplyingPositiveFractionWithNegative_thenSolutionIsCorrect() {
        Fraction number = new Fraction(1,2);
        Fraction multiplicand = new Fraction(-2,4);
        assertEquals(new Fraction(-2,8), number.multiplyWith(multiplicand));
    }

    @Test
    void whenMultiplying_thenMultiplicationIsCommutative() {
        Fraction number = new Fraction(1,3);
        Fraction multiplicand = new Fraction (2,-5);
        assertEquals(number.multiplyWith(multiplicand), multiplicand.multiplyWith(number));
    }

    @Test
    void whenMultiplyingWithMinusOne_thenSignIsChangedCorrectly() {
        Fraction number = new Fraction(1,2);
        assertTrue(number.isPositive());
        assertEquals(new Fraction(1,2), number);
        number = number.multiplyWith(-1);
        assertTrue(number.isNegative());
        assertEquals(new Fraction(-1,2), number);
    }

    @Test
    void whenMultiplyingWithZero_thenDenominatorIsNotZero() {
        Fraction number = new Fraction(1,2);
        number = number.multiplyWith(0);
        assertEquals(new Fraction(0,1), number);
    }

    @Test
    void whenMultiplyingWithInteger_thenSolutionIsCorrect() {
        Fraction number = new Fraction(2,3);
        number = number.multiplyWith(3);
        assertEquals(6, number.getNumerator());
        assertEquals(3, number.getDenominator());
    }
}
