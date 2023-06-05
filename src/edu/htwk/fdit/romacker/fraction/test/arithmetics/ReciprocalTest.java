package edu.htwk.fdit.romacker.fraction.test.arithmetics;

import edu.htwk.fdit.romacker.main.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReciprocalTest {

    @Test
    void givenOrdinaryFraction_thenReciprocalIsCorrect() {
        Fraction number = new Fraction(1,2);
        assertEquals(new Fraction(2,1), number.reciprocal());
    }

    @Test
    void givenFractionNegativeNumerator_thenReciprocalIsCorrect() {
        Fraction negative = new Fraction(-2, 7);
        assertEquals(new Fraction(-7,2), negative.reciprocal());
    }

    @Test
    void givenFractionNegativeDenominator_thenReciprocalIsCorrect() {
        Fraction negative = new Fraction(2, -7);
        assertEquals(new Fraction(-7,2), negative.reciprocal());
    }

}
