package com.pcloud.array;

import java.util.Arrays;

/**
 * Given array a, and a list of ranges [c1, c2], 0 <= c1 <= c2 < a.length. Combine the ranges which are overlapped.
 */
public class CombineRangeInArrayProblem {

    /**
     * A range in array. c1 <= c2
     */
    static class Range {
        public int c1;
        public int c2;

        public Range(int c1, int c2) {
            this.c1 = c1;
            this.c2 = c2;
        }

        /**
         * Checks if range r can be merged to this range.
         *
         * @param r
         * @return true if can merge, otherwise return false
         */
        public boolean canMerge(Range r) {
            int a = r.c1;
            int b = r.c2;

            // intersection case
            if (a <= c1 && c1 <= b) {
                return true;
            }
            if (a <= c2 && c2 <= b) {
                return true;
            }

            // contains
            if (c1 <= a && b <= c2) {
                return true;
            }
            return false;
        }

        /**
         * Merge range r into this range.
         * @param r
         */
        public void merge(Range r) {
            if (r.c1 < c1) {
                c1 = r.c1;
            }
            if (r.c2 > c2) {
                c2 = r.c2;
            }
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Range{");
            sb.append("c1=").append(c1);
            sb.append(", c2=").append(c2);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // given a list of range
        int[][] a = new int[][]{
                new int[]{21, 30},
                new int[]{10, 20},
                new int[]{2, 8},
                new int[]{6, 7},
                new int[]{1, 3},
                new int[]{5, 9}
        };

        Range[] ranges = new Range[a.length];
        boolean[] b = new boolean[a.length];

        for (int i = 0; i < a.length; i++) {
            ranges[i] = new Range(a[i][0], a[i][1]);
        }

        int count;
        do {
            count = 0;
            Arrays.fill(b, false);

            // try to combine Range
            for (int i = 0; i < ranges.length - 1; i++) {
                if (!b[i]) {
                    for (int j = i + 1; j < ranges.length; j++) {
                        if (!b[j] && ranges[i].canMerge(ranges[j])) {
                            System.out.printf("Merge %s to %s\n", ranges[i], ranges[j]);
                            ranges[i].merge(ranges[j]);
                            count++;
                            b[j] = true;
                        }
                    }
                }
            }

            // count new length
            int newLength = 0;
            for (int i = 0; i < ranges.length; i++) {
                if (!b[i]) {
                    newLength++;
                }
            }

            // build new array
            Range[] newRanges = new Range[newLength];
            int k = 0;
            for (int i = 0; i < ranges.length; i++) {
                if (!b[i]) {
                    newRanges[k++] = ranges[i];
                }
            }
            ranges = newRanges;

        } while (count > 0); // break while loop if there is no combination

        // print result
        for (int i = 0; i < ranges.length; i++) {
            System.out.printf("%2d %2d\n", ranges[i].c1, ranges[i].c2);
        }
    }
}
