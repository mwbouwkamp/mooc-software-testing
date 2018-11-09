package tudelft.roman;

import com.sun.org.apache.xml.internal.utils.Hashtree2Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MyRomanNumeralTest {

    private MyRomanNumeral myRomanNumeral;
    private HashMap<String, Integer> resultsMap;

    @BeforeEach
    public void initialize() {
        myRomanNumeral = new MyRomanNumeral();
        resultsMap = new HashMap<>();

    }

    @Test void testEmptyString() {
        int expected = 0;
        int result = myRomanNumeral.convert("");
        assertEquals(expected, result);

    }
    @Test
    public void testSingleNumbers() {
        resultsMap.put("I", 1);
        resultsMap.put("V", 5);
        resultsMap.put("X", 10);
        resultsMap.put("L", 50);
        resultsMap.put("C", 100);
        resultsMap.put("D", 500);
        resultsMap.put("M", 1000);

        for (String key: resultsMap.keySet()) {
            int expected = resultsMap.get(key);
            int result = myRomanNumeral.convert(key);
            assertEquals(expected, result);
        }
    }

    @Test
    public void testSingleDoubleNumber() {
        resultsMap.put("IV", 4);
        resultsMap.put("XL", 40);
        resultsMap.put("CD", 400);
        resultsMap.put("IX", 9);
        resultsMap.put("XC", 90);
        resultsMap.put("CM", 900);

        for (String key: resultsMap.keySet()) {
            int expected = resultsMap.get(key);
            int result = myRomanNumeral.convert(key);
            assertEquals(expected, result);
        }
    }

    @Test
    public void testMultipleSingleNumbers() {
        resultsMap.put("II", 2);
        resultsMap.put("VI", 6);
        resultsMap.put("XX", 20);
        resultsMap.put("LX", 60);
        resultsMap.put("CC", 200);
        resultsMap.put("DC", 600);
        resultsMap.put("MM", 2000);

        for (String key: resultsMap.keySet()) {
            int expected = resultsMap.get(key);
            int result = myRomanNumeral.convert(key);
            assertEquals(expected, result);
        }
    }

    @Test
    public void testSingleNumbersWithDoubleNumbers() {
        resultsMap.put("XIV", 14);
        resultsMap.put("CXL", 140);
        resultsMap.put("CDX", 410);
        resultsMap.put("XIX", 19);
        resultsMap.put("XCI", 91);
        resultsMap.put("MCM", 1900);

        for (String key: resultsMap.keySet()) {
            int expected = resultsMap.get(key);
            int result = myRomanNumeral.convert(key);
            assertEquals(expected, result);
        }
    }
}