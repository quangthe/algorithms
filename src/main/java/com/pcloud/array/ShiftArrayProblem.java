package com.pcloud.array;

import java.util.Arrays;

import com.pcloud.tree.BinaryTree;
import com.pcloud.tree.Node;

/**
 *
 */
public class ShiftArrayProblem {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] data = new int[] {10, 56, 23, 1, 2, 3, 4, 78 ,5, 6, 7, 8, 89, 55};

        for (int i = 0; i < data.length; i++) {
            tree.insert(data[i]);
        }

        final int N = 30;
        int[] a = new int[N];

        search(a, tree.getRoot());

        System.out.println(Arrays.toString(a));
    }

    public static void search(int[]a, Node node) {
        if (node == null) {
            return;
        }

        insert(a, node.data);
        search(a, node.left);
        search(a, node.right);
    }

    public static void insert(int[] a, int value) {
        int z = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = value;
                break;
            }
            if (value > a[i]) {
                z = i;
                break;
            }
        }

        if (z >= 0 && z < a.length) {
            for (int j = a.length - 1; j > z; j--) {
                a[j] = a[j - 1];
            }
            a[z] = value;
        }
    }
}
