package edu.htwk.fdit.romacker.fraction.test.comparison;

import edu.htwk.fdit.romacker.main.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtendedFractionComparisonTest {

    @Test
    void whenComparingIntegerToFraction_thenEqualityEnsuresOneIsOne() {
        Integer oneAsInteger = 1;
        Fraction oneAsFraction = new Fraction(1,1);

        assertEquals(oneAsInteger, oneAsFraction);
    }

    @Test
    void whenComparingFractionToAnInteger_thenEqualityEnsuresOneIsOne() {
        Integer oneAsInteger = 1;
        Fraction oneAsFraction = new Fraction(1,1);
        assertEquals(oneAsFraction, oneAsInteger);
    }

    @Test
    void whenSubtractingOneFractionFromItself_thenSolutionIsZero() {
        Fraction number = new Fraction(1,3);
        Fraction other = new Fraction(1,3);
        assertEquals(0, number.sub(other));
    }

    @Test
    void whenComparingTwoFractionsOfValueZero_thenComparisonIsCorrect() {
        Fraction aZero = new Fraction(0,3);
        Fraction anotherZero = new Fraction(0,-7);

        assertEquals(aZero, anotherZero);
    }

}
