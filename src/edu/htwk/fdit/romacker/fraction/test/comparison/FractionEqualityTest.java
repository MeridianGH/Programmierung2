package edu.htwk.fdit.romacker.fraction.test.comparison;

import edu.htwk.fdit.romacker.main.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionEqualityTest {

    @Test
    void givenSameFractionAsTwoObjects_thenBothFractionsAreNotSame() {
        Fraction fraction = new Fraction (1,2);
        Fraction other = new Fraction(1,2);

        assertTrue(fraction.equals(other));
        assertTrue(other.equals(fraction));
        assertFalse(fraction == other);
    }

    @Test
    void givenSameFractionAsTwoObjects_thenBothFractionsAreEqual() {
        Fraction fraction = new Fraction(1,2);
        Fraction other = new Fraction(1,2);
        assertEquals(fraction, other);
    }

    @Test
    void givenSameFractionInTwoObjectsWithDifferentNumbers_thenFractionIsTheSame() {
        Fraction fraction = new Fraction(1,2);
        Fraction other = new Fraction(2,4);
        assertEquals(fraction, other);
    }

    @Test
    void givenTwoFractionsWithNumeratorZero_bothAreEqual() {
        Fraction zeroTwo = new Fraction(0,2);
        Fraction zeroTwelve = new Fraction(0,12);
        assertEquals(zeroTwo, zeroTwelve);
    }

    @Test
    void givenEqualityToNull_thenEqualityIsFalse() {
        Fraction number = new Fraction(1,2);
        Fraction negativeNumber = new Fraction(-1,2);
        Fraction nullAsFraction = null;

        assertFalse(number.equals(nullAsFraction));
        assertFalse(negativeNumber.equals(nullAsFraction));
    }
}
