package com.pcloud;

/**
 * Created by thetran on 3/30/17.
 */
public class DisjoinSet {
    /**
     * the i’th element (parents[i]) of the array is the parent of the i’th item (i).
     * if parents[i] == i, then i is the representative of a set.
     */
    int[] parents;
    int[] ranks;
    /**
     * The number of items.
     */
    int n;

    public DisjoinSet(int n) {
        this.n = n;
        initSet();
    }

    public void initSet() {
        parents = new int[n];
        ranks = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    /**
     * Finds the representative of the set that
     * i is an element of
     *
     * @param i
     * @return
     */
    public int find(int i) {
        // If i is the parent of itself
        if (parents[i] == i) {
            // Then i is the representative of
            // this set
            return i;
        } else {
            // Else if i is not the parent of
            // itself, then i is not the
            // representative of his set. So we
            // recursively call Find on its parent
            return find(parents[i]);
        }
    }

    public void union(int i, int j) {
        // Find the representatives (or the root nodes)
        // for the set that includes i
        int irep = find(i);

        // And do the same for the set that includes j
        int jrep = find(j);

        // Elements are in same set, no need to
        // unite anything.
        if (irep == jrep) {
            return;
        }

        // Get the rank of i’s tree
        int irank = ranks[irep];

        // Get the rank of j’s tree
        int jrank = ranks[jrep];

        // If i’s rank is less than j’s rank
        if (irank < jrank) {
            // Then move i under j
            parents[irep] = jrep;
        }

        // Else if j’s rank is less than i’s rank
        else if (jrank < irank) {
            // Then move j under i
            parents[jrep] = irep;
        } else {
            // Then move i under j (doesn’t matter
            // which one goes where)
            parents[irep] = jrep;

            // And increment the the result tree’s
            // rank by 1
            ranks[jrep]++;
        }
    }

    public static void main(String[] args)
    {
        // Let there be 6 persons with ids as
        // 0, 1, 2, 3, 4, 5
        int n = 6;
        DisjoinSet dus = new DisjoinSet(n);

        // 0 is a friend of 2
        dus.union(0, 2);

        // 4 is a friend of 2
        dus.union(4, 2);

        // 8 is friend of 4
        dus.union(5, 4);

        // 3 is a friend of 1
        dus.union(3, 1);

        // Check if 4 is a friend of 0
        if (dus.find(5) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Check if 1 is a friend of 0
        if (dus.find(1) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
