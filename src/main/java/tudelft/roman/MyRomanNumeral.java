package tudelft.roman;

import java.util.HashMap;
import java.util.Map;

public class MyRomanNumeral {

    public enum RomanValues {
        IV ("IV", 4),
        XL ("XL", 40),
        CD ("CD", 400),
        IX ("IX", 9),
        XC ("XC", 90),
        CM ("CM", 900),
        I ("I", 1),
        V ("V", 5),
        X ("X", 10),
        L ("L", 50),
        C ("C", 100),
        D ("D", 500),
        M ("M", 1000);

        private final String representation;
        private final int value;

        RomanValues(String representation, int value) {
            this.representation = representation;
            this.value = value;
        }
    }

    public int convert(String romanNumeral) {
        int toReturn = 0;
        for (RomanValues value: RomanValues.values())
            while (romanNumeral.contains(value.representation)) {
                toReturn += value.value;
                romanNumeral = romanNumeral.replaceFirst(value.representation.toString(), "");
            }
        return toReturn;
    }

    public static void main(String[] args) {
        MyRomanNumeral myRomanNumeral = new MyRomanNumeral();
        System.out.println(myRomanNumeral.convert("XCIV"));
    }
}
