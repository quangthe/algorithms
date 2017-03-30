package com.pcloud;

import java.util.TreeSet;

public class DemoDisjoinSetApp {
    public static void main(String[] args) {
        int n = 6;
        int numberOfEdge = 6;
        int[] from     = new int[] {1, 1, 2, 2, 2, 3};
        int[] to       = new int[] {2, 2, 3, 3, 4, 5};
        int[] weight   = new int[] {1, 3, 1, 2, 4, 1};

        int[][] counts = new int[n][n];

        TreeSet<Integer> distintWeights = new TreeSet<>();
        for (int i = 0; i < weight.length; i++) {
            distintWeights.add(weight[i]);
        }

        while (distintWeights.size() > 0) {
            int w = distintWeights.pollFirst();
            DisjoinSet ds = new DisjoinSet(n);
            for (int i = 0; i < numberOfEdge; i++) {
                if (weight[i] == w) {
                    ds.union(from[i], to[i]);
                }
            }
            for (int i = 1; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (ds.find(i) == ds.find(j)) {
                        counts[i][j]++;
                    }
                }
            }
        }

        // print result
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (counts[i][j] > 0) {
                    System.out.printf("counts[%d, %d] = %d\n", i, j, counts[i][j]);
                }
            }
        }
    }
}
