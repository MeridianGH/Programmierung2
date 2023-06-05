package edu.htwk.fdit.romacker.fraction.test.comparison;

import edu.htwk.fdit.romacker.main.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionComparisonTest {

    @Test
    void givenLargeAndSmallFraction_whenComparing_thenLargeIsGreaterThanSmall() {
        Fraction large = new Fraction(1,2);
        Fraction small = new Fraction(1,3);
        assertTrue(large.compareTo(small) > 0);
        assertTrue(small.compareTo(large) < 0);
    }

    @Test
    void givenComparisonWithNull_thenCorrectException_IsThrown() {
        Fraction number = new Fraction(1,2);
        assertThrows(NullPointerException.class, () -> number.compareTo(null));
    }

    @Test
    void givenThreeFractions_thenComparison_isTransitive() {
        Fraction x = new Fraction(3,1);
        Fraction y = new Fraction(2,1);
        Fraction z = new Fraction(1,1);

        assertTrue(x.compareTo(y) > 0);
        assertTrue(y.compareTo(z) > 0);
        assertTrue(x.compareTo(z) > 0);
    }

    @Test
    void givenComparisonBetweenTwoFractions_thenSignumIsCorrectlyCompared() {
        Fraction x = new Fraction(2,1);
        Fraction y = new Fraction(-2,1);

        assertEquals(x.compareTo(y), -1*y.compareTo(x));
    }

    @Test
    void whenCompareMethodExists_thenInterfaceIsUsed() {
        Fraction number = new Fraction(1,2);
        assertTrue(
                number instanceof Comparable<?>
        );
    }
}
