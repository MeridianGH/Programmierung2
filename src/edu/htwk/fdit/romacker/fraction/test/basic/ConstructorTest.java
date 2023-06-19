package edu.htwk.fdit.romacker.fraction.test.basic;

import edu.htwk.fdit.romacker.fraction.main.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConstructorTest {

    @Test
    void whenConstructingFractionWithNegativeNumerator_thenSignIsCorrect() {
        Fraction number = new Fraction(-1,2);
        assertEquals(1, number.getNumerator());
        assertEquals(2, number.getDenominator());
        assertTrue(number.isNegative());
    }

    @Test
    void whenConstructingFractionWithNegativeDenominator_thenSignIsCorrect() {
        Fraction number = new Fraction(1,-2);
        assertEquals(1, number.getNumerator());
        assertEquals(2, number.getDenominator());
        assertTrue(number.isNegative());
    }

    @Test
    void whenConstructingFractionWithPositiveNumbers_thenSignIsCorrect() {
        Fraction number = new Fraction(1,3);
        assertTrue(number.isPositive());
    }

    @Test
    void whenConstructingFractionWithNegativeNumbers_thenSignIsCorrect() {
        Fraction number = new Fraction(-1,-3);
        assertTrue(number.isPositive());
    }

    @Test
    void whenConstructingZeroAsFraction_thenSignIsNeitherPositiveNorNegative() {
        Fraction number = new Fraction(0,1);
        assertFalse(number.isPositive());
        assertFalse(number.isNegative());
    }

    @Test
    void whenConstructingWithInteger_thenConstructionIsCorrect() {
        Fraction number = new Fraction(7);
        assertEquals(new Fraction(7,1), number);
    }
}
