package edu.htwk.fdit.romacker.fraction.test.formating;

import edu.htwk.fdit.romacker.fraction.main.Fraction;
import edu.htwk.fdit.romacker.fraction.main.FractionFormat;
import edu.htwk.fdit.romacker.fraction.main.FractionFormater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionFormaterTest {

    @Test
    void whenFormatingAnOrdinaryFraction_thenToStringOfFractionIsReturned() {
        Fraction number = new Fraction(-23,7);
        String result = FractionFormater.format(number, FractionFormat.AS_FRACTION);
        assertEquals("-23/7", result);
    }

    @Test
    void whenFormatingFractionAsMixed_thenFractionValuesAreDisplayedCorrectly() {
        Fraction number = new Fraction (23, -7);
        String result = FractionFormater.format(number, FractionFormat.AS_WHOLE_NUMBER);
        assertEquals("-3 2/7", result);
    }

}
