package com.pcloud.misc;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Keeps top N elements on TreeSet.
 */
public class RetainTopNElement {
    public static void main(String[] args) {
        // keep top 5 largest elements
        final int N = 5;
        TreeSet<Integer> ts = new TreeSet<>();

        for (int i = 100; i >= 0; i--) {
            ts.add(i);
            if (ts.size() > N) {
                ts.pollFirst();
            }
        }
        System.out.println(Arrays.toString(ts.toArray()));
    }
}
