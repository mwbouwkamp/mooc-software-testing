package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountLettersTest {

    @Test
    public void multipleMatchingWords() {
        int words = new CountLetters().count("cats|dogs");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatch() {
        int words = new CountLetters().count("cats|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void matchingWordFirstWithR() {
        int words = new CountLetters().count("deer|cat");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void matchingWordSecondWithR() {
        int words = new CountLetters().count("cat|deer");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void NoWords() {
        int words = new CountLetters().count("cat|dog");
        Assertions.assertEquals(0, words);
    }
}