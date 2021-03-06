package com.pcloud.tree;

/**
 * The binary tree is built using this nested node class.
 * Each node stores one data element, and has left and right
 * sub-tree pointer which may be null.
 * The node is a "dumb" nested class -- we just use it for
 * storage; it does not have any methods.
 */
public class Node {
    public Node left;
    public Node right;
    public int data;

    public Node(int newData) {
        left = null;
        right = null;
        data = newData;
    }

    @Override
    public String toString() {
        return String.format("node[ %d ]", data);
    }
}