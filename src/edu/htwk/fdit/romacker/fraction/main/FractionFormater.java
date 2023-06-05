package edu.htwk.fdit.romacker.fraction.main;

public class FractionFormater {

    public static String format(Fraction fraction, FractionFormat format) {
        if (format == FractionFormat.AS_WHOLE_NUMBER) {
            int mod = fraction.getNumerator() % fraction.getDenominator();
            if (mod == 0) { return String.valueOf(fraction.getNumerator() / fraction.getDenominator()); }
            return (fraction.isNegative() ? "-" : "") + (fraction.getNumerator() / fraction.getDenominator()) + " " + mod + "/" + fraction.getDenominator();
        } else {
            return (fraction.isNegative() ? "-" : "") + fraction.getNumerator()+ "/" + fraction.getDenominator();
        }
    }
}
