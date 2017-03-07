package com.pcloud.string;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by thetran on 3/8/17.
 */
public class TwoCharacterSolutionTest {
    private TwoCharacterSolution solution;
    @Before
    public void setUp() throws Exception {
        solution = new TwoCharacterSolution();

    }

    @Test
    public void solve() throws Exception {
        assertEquals(5, solution.solve("beabeefeab"));
        assertEquals(2, solution.solve("bean"));
        assertEquals(0, solution.solve("b"));
        assertEquals(3, solution.solve("beeworkinghard"));
        assertEquals(3, solution.solve("tobeornottobee"));
    }

}