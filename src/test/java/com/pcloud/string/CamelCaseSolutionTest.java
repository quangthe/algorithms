package com.pcloud.string;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by thetran on 3/7/17.
 */
public class CamelCaseSolutionTest {
    private CamelCaseSolution camelCaseSolution;
    @Before
    public void setUp() throws Exception {
        camelCaseSolution = new CamelCaseSolution();
    }

    @Test
    public void countWord() throws Exception {
        assertEquals(3, camelCaseSolution.countWord("dispatchSaveEvent"));
        assertEquals(1, camelCaseSolution.countWord("save"));
    }

}