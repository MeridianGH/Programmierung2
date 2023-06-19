package edu.htwk.fdit.romacker.fraction.test.arithmetics;

import edu.htwk.fdit.romacker.fraction.main.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubtractionTest {

    @Test
    void whenSubtractingTwoFractions_thenSolutionIsCorrectAndNotReduced() {
        Fraction minuend = new Fraction(2,4);
        Fraction subtrahend = new Fraction(2,6);
        Fraction solution = minuend.sub(subtrahend);
        assertEquals(4, solution.getNumerator());
        assertEquals(24, solution.getDenominator());
    }

    @Test
    void whenSubtractingNegativeFractionFromPositive_thenSolutionIsCorrect() {
        Fraction minuend = new Fraction(1,2);
        Fraction subtrahend = new Fraction(-1, 3);
        assertEquals(new Fraction(1,6), minuend.sub(subtrahend));
    }

    @Test
    void whenSubtractingPositiveFractionFromNegative_thenSolutionIsCorrect() {
        Fraction minuend = new Fraction(-1,2);
        Fraction subtrahend = new Fraction(1, 3);
        assertEquals(new Fraction(-5,6), minuend.sub(subtrahend));
    }

    @Test
    void whenSubtractingNegativeFractionFromNegative_thenSolutionIsCorrect() {
        Fraction minuend = new Fraction(-1,2);
        Fraction subtrahend = new Fraction(-1, 3);
        assertEquals(new Fraction(-5,6), minuend.sub(subtrahend));
    }

    @Test
    void whenPerformingSubtraction_thenOriginalFractionRemainsUnchanged() {
        Fraction number = new Fraction(1,2);
        Fraction original = number;

        Fraction solution = number.sub(new Fraction(0,1));

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
