package com.pcloud.tree;

/**
 * Hello world!
 */
public class DemoBinaryTreeApp {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        int[] data = new int[] {7, 4, 12, 2, 6, 9, 19, 1, 3, 5, 8, 11, 15, 20};

        for (int i = 0; i < data.length; i++) {
            tree.insert(data[i]);
        }

        BinaryTreePrinter.printNode(tree.getRoot());

        for (int i = 0; i < data.length; i++) {
            System.out.printf("Delete %d\n", data[i]);
            tree.delete(data[i]);
            BinaryTreePrinter.printNode(tree.getRoot());
        }
    }
}
