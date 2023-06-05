package edu.htwk.fdit.romacker.fraction.test.arithmetics;

import edu.htwk.fdit.romacker.main.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReduceTest {

    @Test
    void whenFractionIsAlreadyReduced_thenNoChangePerformed() {
        Fraction number = new Fraction(1,7);
        assertEquals(number, number.reduced());
    }

    @Test
    void whenFractionIsReducible_thenSolutionIsCorrect() {
        Fraction reducible = new Fraction(7,14);
        assertEquals(new Fraction(1,2), reducible.reduced());
    }

    @Test
    void whenNegativeFractionIsReducible_thenSolutionIsCorrect() {
        Fraction reducible = new Fraction(7,-14);
        assertEquals(new Fraction(-1,2), reducible.reduced());
    }

    @Test
    void whenNegativeFractionIsReduced_thenSignIsPreserverd() {
        Fraction original = new Fraction(-1,2);
        Fraction reduced = original.reduced();
        assertEquals(new Fraction(-1,2), reduced);
        assertTrue(reduced.isNegative());
    }
}
