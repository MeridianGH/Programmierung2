package edu.htwk.fdit.romacker.fraction.test.arithmetics;

import edu.htwk.fdit.romacker.fraction.main.Fraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdditionTest {

    @Test
    void whenAddingTwoFractions_thenSolutionIsCorrectAndNotReduced() {
        Fraction summand = new Fraction(2,4);
        Fraction addend = new Fraction(2,6);
        Fraction solution = summand.add(addend);
        assertEquals(20, solution.getNumerator());
        assertEquals(24, solution.getDenominator());
    }

    @Test
    void whenAddingNegativeFractionToPositive_thenSolutionIsCorrect() {
        Fraction summand = new Fraction(1,2);
        Fraction addend = new Fraction(-1, 3);
        assertEquals(new Fraction(1,6), summand.add(addend));
    }

    @Test
    void whenAddingPositiveFractionToNegative_thenSolutionIsCorrect() {
        Fraction summand = new Fraction(-1,2);
        Fraction addend = new Fraction(1, 3);
        assertEquals(new Fraction(-1,6), summand.add(addend));
    }

    @Test
    void whenAddingNegativeFractionToNegative_thenSolutionIsCorrect() {
        Fraction summand = new Fraction(-1,2);
        Fraction addend = new Fraction(-1, 3);
        assertEquals(new Fraction(-5,6), summand.add(addend));
    }

    @Test
    void whenAddingTwoFractions_thenAdditionIsCommutative() {
        Fraction number = new Fraction(1,3);
        Fraction other = new Fraction (2,5);
        assertEquals(number.add(other), other.add(number));
    }

    @Test
    void whenPerformingAddtion_thenOriginalFractionRemainsUnchanged() {
        Fraction number = new Fraction(1,2);
        Fraction original = number;

        Fraction solution = number.add(new Fraction(0,1));

        assertEquals(1, solution.getNumerator());
        assertEquals(2, solution.getDenominator());
        assertEquals(1, number.getNumerator());
        assertEquals(2, number.getDenominator());

        assertTrue(number.equals(solution));
        assertTrue(number.equals(original));
        assertFalse(number == solution);
        assertTrue(number == original);
    }
}
