package com.oleamedical;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

public class CombineTest extends TestCase {

    @Test
    public void test() {
        Integer[][] data = {
                {1,2,3},
                {4,5},
                {6}
        };

        Integer[][] resultToFind = {
                {1,4,6},
                {1,5,6},
                {2,4,6},
                {2,5,6},
                {3,4,6},
                {3,5,6},
        };

        Object[][] result = Combine.combine(data);

        for (int i = 0; i < resultToFind.length; i++) {
            assertTrue(Arrays.deepEquals(result[i], resultToFind[i]));
        }

    }

}