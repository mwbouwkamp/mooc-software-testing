package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TwoNumbersSumTest {

    static private TwoNumbersSum twoNumbersSum;
    static private ArrayList<Integer> first;
    static private ArrayList<Integer> second;
    static private ArrayList<Integer> expected;
    static private ArrayList<Integer> result;

    @BeforeAll
    static void setup() {
        twoNumbersSum = new TwoNumbersSum();
        first = new ArrayList<>();
        second = new ArrayList<>();
        expected = new ArrayList<Integer>();
    }

    @Test
    void twoEmptyListsTest() {
        result = twoNumbersSum.addTwoNumbers(first, second);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void twoSingleElementListsNoComplementTest() {
        first.add(2);
        second.add(2);
        expected.add(4);
        result = twoNumbersSum.addTwoNumbers(first, second);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void twoSingleElementListsComplementTest() {
        first.add(6);
        second.add(6);
        expected.add(1);
        expected.add(2);
        result = twoNumbersSum.addTwoNumbers(first, second);
        Assertions.assertEquals(expected, result);
    }
}
