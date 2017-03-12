package com.pcloud.dynamic;

/**
 *
 */
public class TheBagProblem {

    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }


    /**
     * Weight of item array.
     */
    private int[] W;
    /**
     * Value of item array.
     */
    private int[] V;

    /**
     * 2 dimensions table for dynamic programing.
     */
    private int[][] F;

    /**
     * The number of item.
     */
    private int n;
    /**
     * The maximum weight the thief can handle.
     */
    private int M;

    private Item[] getItems() {
        return new Item[]{
                new Item(3, 3),
                new Item(4, 4),
                new Item(5, 4),
                new Item(9, 18),
                new Item(4, 4)
        };
    }

    /**
     * @param items list of item
     * @param M maximum weight the thief can handle.
     */
    private void init(Item[] items, int M) {

        this.n = items.length;
        this.M = M;

        W = new int[items.length + 1];
        V = new int[items.length + 1];

        for (int i = 0; i < items.length; i++) {
            W[i + 1] = items[i].weight;
            V[i + 1] = items[i].value;
        }


        F = new int[n + 1][M + 1];

    }

    public void optimize() {
        // F[0][j] = 0
        for (int j = 0; j <= M; j++) {
            F[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= M; j++) {

                // Suppose not choose item i-th
                F[i][j] = F[i - 1][j];

                // If choosing item i-th is better
                if ((W[i] <= j) && (F[i][j] < V[i] + F[i - 1][j - W[i]])) {
                    F[i][j] = V[i] + F[i - 1][j - W[i]];
                }
            }
        }
    }

    public void trace() {
        System.out.println("Maximum value = " + F[n][M]);
        int nth = n;
        int max = M;
        while (nth > 0) {
            if (F[nth][max] != F[nth - 1][max]) {
                System.out.printf("Item w=%d, v=%d\n", W[nth], V[nth]);

                max = max - W[nth];
            }
            nth--;
        }
    }

    public static void main(String[] args) {
        TheBagProblem problem = new TheBagProblem();

        problem.init(problem.getItems(), 11);
        problem.optimize();
        problem.trace();
    }
}
