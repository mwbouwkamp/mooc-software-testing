package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CaesarShiftCipherTest {

    private CaesarShiftCipher caesarShiftCipher;

    @BeforeEach
    public void init() {
        caesarShiftCipher = new CaesarShiftCipher();
    }

    @Test
    public void noShift() {
        String message = "abc";
        int shift = 0;
        String expected = message;
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void Shift26() {
        String message = "abc";
        int shift = 26;
        String expected = message;
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void ShiftPositive5NoCrossing() {
        String message = "klm";
        int shift = 5;
        String expected = "pqr";
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void ShiftNegative5NoCrossing() {
        String message = "klm";
        int shift = -5;
        String expected = "fgh";
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void ShiftPositive5Crossing() {
        String message = "xyz";
        int shift = 5;
        String expected = "cde";
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void ShiftNegative5Crossing() {
        String message = "abc";
        int shift = -5;
        String expected = "vwx";
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void invalidNoShift() {
        String message = "!abc";
        int shift = 0;
        String expected = "invalid";
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void invalidShiftPositive5() {
        String message = "!abc";
        int shift = 5;
        String expected = "invalid";
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);

    }
}
