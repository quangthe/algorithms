package com.pcloud.string;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by thetran on 3/7/17.
 */
public class SuperReducedStringSolutionTest {
    private SuperReducedStringSolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new SuperReducedStringSolution();
    }

    @Test
    public void testReduceEmpty() {
        String s = solution.reduce("abbacddcehhhhe");
        assertEquals("", s);
    }

    @Test
    public void testReduceNotEmpty() {
        String s = solution.reduce("aaabccddd");
        assertEquals("abd", s);
    }
}