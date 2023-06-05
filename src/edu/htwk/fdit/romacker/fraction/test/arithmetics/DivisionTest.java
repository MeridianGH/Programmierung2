package edu.htwk.fdit.romacker.fraction.test.arithmetics;

import edu.htwk.fdit.romacker.main.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisionTest {

    @Test
    void whenDividingPositiveFractionByPositiveFraction_thenSolutionIsCorrectAndNotReduced() {
        Fraction dividend = new Fraction(5,4);
        Fraction divisor = new Fraction(4,5);
        Fraction solution = dividend.divideBy(divisor);

        assertEquals(25, solution.getNumerator());
        assertEquals(16, solution.getDenominator());
        assertEquals(new Fraction(25,16), solution);
    }

    @Test
    void whenDividingNegativeFractionByPositiveFraction_thenSolutionIsCorrect() {
        Fraction dividend = new Fraction(1,2);
        Fraction divisor = new Fraction(-1,4);
        assertEquals(new Fraction(-4,2), dividend.divideBy(divisor));
    }

    @Test
    void whenDividingPositiveFractionByNegativeFraction_thenSolutionIsCorrect() {
        Fraction dividend = new Fraction(-1,2);
        Fraction divisor = new Fraction(1,4);
        assertEquals(new Fraction(-4,2), dividend.divideBy(divisor));
    }

    @Test
    void whenDivingNegativeFractionByNegativeFraction_thenSolutionIsCorrect() {
        Fraction dividend = new Fraction(-1,2);
        Fraction divisor = new Fraction(-1,4);
        assertEquals(new Fraction(4,2), dividend.divideBy(divisor));
    }

    @Test
    void whenDividingByNegativeInteger_thenSolutionIsCorrect() {
        Fraction dividend = new Fraction(5,7);
        assertEquals(new Fraction(-5,14), dividend.divideBy(-2));
    }

    @Test
    void whenDividingByPositiveInteger_thenSolutionIsCorrect() {
        Fraction dividend = new Fraction(5,7);
        assertEquals(new Fraction(5,14), dividend.divideBy(2));
    }

}
