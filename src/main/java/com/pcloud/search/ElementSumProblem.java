package com.pcloud.search;

/**
 * Find elements in a given array, sum of elements equals to given number.
 */
public class ElementSumProblem {
    int sum = 9;
    int[] a = new int[] {4, 2, 1, 5, 7, 8, 9};
    boolean[] b = new boolean[a.length];
    boolean found = false;

    public static void main(String[] args) {

        ElementSumProblem problem = new ElementSumProblem();

        problem.solve();
    }

    public void solve() {
        tryWith(0, sum);
    }
    public void tryWith(int i, int sum) {
        if (sum == 0) {
//            found = true;
            printResult();
            return;
        }
        for (int j = i; j < a.length; j++) {
            if (!found && b[j] == false) {
                b[j] = true;
                tryWith(j, sum - a[j]);
                b[j] = false;

                if (sum - a[j] == 0) {
                    return;
                }
            }
        }
    }
    private void printResult() {
        for (int i = 0; i < a.length; i++) {
            if (b[i]) {
                System.out.printf("%d ", a[i]);
            }
        }
        System.out.println();
    }
}
