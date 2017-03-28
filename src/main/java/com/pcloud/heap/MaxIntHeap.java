package com.pcloud.heap;

import java.util.Arrays;

public class MaxIntHeap {
    private int capacity = 10;
    private int size = 0;
    private int[] items = new int[capacity];

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();

        return item;
    }

    private void heapifyDown() {
        // start at root node
        int index = 0;

        // as long as I have children, keep walking down and fix up my heap
        // we check with left child because if there no left child, there's no way to have right child
        while (hasLeftChild(index)) {
            int biggerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (items[index] > items[biggerChildIndex]) {
                break; // heap is fixed
            } else {
                swap(index, biggerChildIndex);
            }
            // going down
            index = biggerChildIndex;
        }
    }

    public void add(int item) {
        ensureCapacity();

        items[size] = item;
        size++;

        heapifUp();
    }

    private void heapifUp() {
        // start with new added item
        int index = size - 1;

        // compare with parent
        while (hasParent(index) && parent(index) < items[index]) {
            swap(getParentIndex(index), index);
            // going up
            index = getParentIndex(index);
        }
    }

    private void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private int parent(int childIndex) {
        return items[getParentIndex(childIndex)];
    }

    private int leftChild(int parentIndex) {
        return items[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return items[getRightChildIndex(parentIndex)];
    }

    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return getLeftChildIndex(parentIndex) + 1;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int getSize() {
        return size;
    }
}
