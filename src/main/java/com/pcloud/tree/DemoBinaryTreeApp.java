package com.pcloud.tree;

/**
 * Hello world!
 */
public class DemoBinaryTreeApp {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        int[] data = new int[] {4, 1, 3, 2, 5, 8, 0, 9, 7, 34, 89};

        for (int i = 0; i < data.length; i++) {
            tree.insert(data[i]);
        }

        boolean hasPathSum = tree.hasPathSum(7);
        System.out.println("Has path sum  = 7: " + hasPathSum);

        BinaryTreePrinter.printNode(tree.getRoot());


        Node node = tree.findMinimumNodeGreaterThan(20);
        System.out.printf("Minimum node greater than %d is %s\n", 20, node);
    }
}
