package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {

    private GHappy gHappy;
    @BeforeEach
    public void initialize() {
        gHappy = new GHappy();
    }

    @ParameterizedTest(name = "input={0}, output={1}")
    @CsvSource({"gABCD,false", "ABgCD,false", "ABCDg, false"})
    public void singleG(String string, boolean expectedResult) {
        boolean result = gHappy.gHappy(string);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "input={0}, output={1}")
    @CsvSource({"ggABCD,true", "ABggCD,true", "ABCDgg, true"})
    public void doubleG(String string, boolean expectedResult) {
        boolean result = gHappy.gHappy(string);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "input={0}, output={1}")
    @CsvSource({"gggABCD,true", "ABgggCD,true", "ABCDggg, true"})
    public void tripleG(String string, boolean expectedResult) {
        boolean result = gHappy.gHappy(string);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "input={0}, output={1}")
    @CsvSource({"ggAgBCD,false", "ggABCDg,false", "gAggBCD, false", "gABCDgg, false",
            "AggBCDg,false", "AggBCgD,false", "AgBCDgg,false", "AgBCggD,false", "AggBCgD,false", "AgBCggD,false"})
    public void singleAndDoubleG(String string, boolean expectedResult) {
        boolean result = gHappy.gHappy(string);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "input={0}, output={1}")
    @CsvSource({"ggAggBCD,true", "ggABCDgg,true", "AggBCggD,true", "AggBBCDbb,true"})
    public void doubleAndDoubleG(String string, boolean expectedResult) {
        boolean result = gHappy.gHappy(string);
        Assertions.assertEquals(expectedResult, result);
    }

}
