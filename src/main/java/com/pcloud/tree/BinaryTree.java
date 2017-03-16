package com.pcloud.tree;

/**
 * Search Binary Tree.
 */
public class BinaryTree {
    /**
     * Root node pointer. Will be null for an empty tree.
     */
    private Node root;

    /**
     * Creates an empty binary tree -- a null root pointer.
     */
    public void BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    /**
     * Returns true if the given target is in the binary tree.
     * Uses a recursive helper.
     */
    public boolean lookup(int data) {
        return lookup(root, data);
    }


    /**
     * Recursive lookup  -- given a node, recur
     * down searching for the given data.
     */
    private boolean lookup(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (data == node.data) {
            return true;
        } else if (data < node.data) {
            return lookup(node.left, data);
        } else {
            return lookup(node.right, data);
        }
    }

    /**
     * Inserts the given data into the binary tree.
     * Uses a recursive helper.
     */
    public void insert(int data) {
        root = insert(root, data);
    }


    /**
     * Recursive insert -- given a node pointer, recur down and
     * insert the given data into the tree. Returns the new
     * node pointer (the standard way to communicate
     * a changed pointer back to the caller).
     */
    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }

        return node; // in any case, return the new pointer to the caller
    }

    /**
     * Returns the number of nodes in the tree.
     * Uses a recursive helper that recurs
     * down the tree and counts the nodes.
     */
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + 1 + size(node.right);
    }

    /**
     * Returns the max root-to-leaf depth of the tree.
     * Uses a recursive helper that recurs down to find
     * the max depth.
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            // use the larger + 1
            return (Math.max(lDepth, rDepth) + 1);
        }
    }

    /**
     * Returns the min value in a non-empty binary search tree.
     * Uses a helper method that iterates to the left to find
     * the min value.
     */
    public int minValue() {
        return minValue(root);
    }

    private int minValue(Node node) {
        Node currentNode = node;
        while (currentNode != null) {
            currentNode = currentNode.left;
        }
        return currentNode.data;
    }

    /**
     * Returns the max value in a non-empty binary search tree.
     * Uses a helper method that iterates to the right to find
     * the max value.
     */
    public int maxValue() {
        return maxValue(root);
    }

    private int maxValue(Node node) {
        Node currentNode = node;
        while (currentNode != null) {
            currentNode = currentNode.right;
        }
        return currentNode.data;
    }

    public Node findMinimumNodeGreaterThan(int v) {
        Node currentNode = getRoot();
        int delta = Integer.MAX_VALUE;
        Node result = null;

        while (currentNode != null) {
            if (currentNode.data > v && currentNode.data - v < delta) {
                delta = currentNode.data - v;
                result = currentNode;

                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return result;
    }

    /**
     * Prints the node values in the "inorder" order.
     * Uses a recursive helper to do the traversal.
     */
    public void printTree() {
        printTree(root);
        System.out.println();
    }

    private void printTree(Node node) {
        if (node == null) return;

        // left, node itself, right
        printTree(node.left);
        System.out.print(node.data + "  ");
        printTree(node.right);
    }

    /**
     * Prints the node values in the "postorder" order.
     * Uses a recursive helper to do the traversal.
     */
    public void printPostorder() {
        printPostorder(root);
        System.out.println();
    }

    public void printPostorder(Node node) {
        if (node == null) return;

        // first recur on both subtrees
        printPostorder(node.left);
        printPostorder(node.right);

        // then deal with the node
        System.out.print(node.data + "  ");
    }


    /**
     * Given a tree and a sum, returns true if there is a path from the root
     * down to a leaf, such that adding up all the values along the path
     * equals the given sum.
     * Strategy: subtract the node value from the sum when recurring down,
     * and check to see if the sum is 0 when you run out of tree.
     */
    public boolean hasPathSum(int sum) {
        return (hasPathSum(root, sum));
    }

    private boolean hasPathSum(Node node, int sum) {
        // return true if we run out of tree and sum==0
        if (node == null) {
            return sum == 0;
        } else {
            // otherwise check both subtrees
            int subSum = sum - node.data;
            return (hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum));
        }
    }

    /**
     * Utility that prints ints from an array on one line.
     */
    private void printArray(int[] ints, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }

    /**
     * Changes the tree into its mirror image.
     *
     * So the tree...
     * 4
     * / \
     * 2   5
     * / \
     * 1  3
     *
     * is changed to...
     * 4
     * / \
     * 5   2
     * / \
     * 3  1
     *
     * Uses a recursive helper that recurs over the tree,
     * swapping the left/right pointers.
     */
    public void mirror() {
        mirror(root);
    }

    private void mirror(Node node) {
        if (node != null) {
            // do the sub-trees
            mirror(node.left);
            mirror(node.right);

            // swap the left/right pointers
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    /**
     * Tests if a tree meets the conditions to be a
     * binary search tree (BST).
     */
    public boolean isBST() {
        return isBST(root);
    }

    /**
     * Recursive helper -- checks if a tree is a BST
     * using minValue() and maxValue() (not efficient).
     */
    private boolean isBST(Node node) {
        if (node == null) {
            return true;
        }

        // do the subtrees contain values that do not
        // agree with the node?
        if (node.left != null && maxValue(node.left) > node.data) {
            return false;
        }
        if (node.right != null && minValue(node.right) <= node.data) {
            return false;
        }

        // check that the subtrees themselves are ok
        return isBST(node.left) && isBST(node.right);
    }

    /**
     * Tests if a tree meets the conditions to be a
     * binary search tree (BST). Uses the efficient
     * recursive helper.
     */
    public boolean isBST2() {
        return isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Efficient BST helper -- Given a node, and min and max values,
     * recurs down the tree to verify that it is a BST, and that all
     * its nodes are within the min..max range. Works in O(n) time --
     * visits each node only once.
     */
    private boolean isBST2(Node node, int min, int max) {
        if (node == null) {
            return true;
        } else {
            // left should be in range  min...node.data
            boolean leftOk = isBST2(node.left, min, node.data);

            // if the left is not ok, bail out
            if (!leftOk) {
                return false;
            }

            // right should be in range node.data+1..max
            boolean rightOk = isBST2(node.right, node.data + 1, max);

            return rightOk;
        }
    }


}
