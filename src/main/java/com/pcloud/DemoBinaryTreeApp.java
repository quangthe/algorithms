package com.pcloud;

import com.pcloud.tree.BinaryTree;
import com.pcloud.tree.BinaryTreePrinter;

/**
 * Hello world!
 */
public class DemoBinaryTreeApp {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        int[] data = new int[] {4, 1, 3, 2, 5, 8, 0, 9, 7};

        for (int i = 0; i < data.length; i++) {
            tree.insert(data[i]);
        }

        boolean hasPathSum = tree.hasPathSum(7);
        System.out.println("Has path sum  = 7: " + hasPathSum);

        BinaryTreePrinter.printNode(tree.getRoot());

        tree.mirror();

        BinaryTreePrinter.printNode(tree.getRoot());
    }
}
