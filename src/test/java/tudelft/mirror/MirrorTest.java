package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MirrorTest {

    @Test
    public void emptyStringTest() {
        String string = "";
        String expected = "";
        Assertions.assertTrue(expected.equals(new Mirror().mirrorEnds(string)));
    }

    @Test
    public void singleCharTest() {
        String string = "a";
        String expected = "a";
        Assertions.assertTrue(expected.equals(new Mirror().mirrorEnds(string)));
    }

    @Test void multipleCharTestNoMirror() {
        String string = "abcde";
        String expected = "";
        Assertions.assertTrue(expected.equals(new Mirror().mirrorEnds(string)));
    }

    @Test void multipleCharTestMirrorSingleChar() {
        String string = "abcda";
        String expected = "a";
        Assertions.assertTrue(expected.equals(new Mirror().mirrorEnds(string)));
    }

    @Test void multipleCharTestMirrorOddMultipleChars() {
        String string = "abcdecba";
        String expected = "abc";
        Assertions.assertTrue(expected.equals(new Mirror().mirrorEnds(string)));
    }

    @Test void multipleCharTestMirrorEvenMultipleChars() {
        String string = "abcdba";
        String expected = "ab";
        Assertions.assertTrue(expected.equals(new Mirror().mirrorEnds(string)));
    }

    @Test void multipleCharTestPalindromeEven() {
        String string = "abccba";
        String expected = "abccba";
        Assertions.assertTrue(expected.equals(new Mirror().mirrorEnds(string)));
    }

    @Test void multipleCharTestPalindromeOdd() {
        String string = "abcdcba";
        String expected = "abcdcba";
        String result = new Mirror().mirrorEnds(string);
        Assertions.assertTrue(expected.equals(new Mirror().mirrorEnds(string)));
    }
}
