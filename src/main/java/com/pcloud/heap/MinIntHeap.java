package com.pcloud.heap;

import java.util.Arrays;

public class MinIntHeap {
    private int capacity = 10;
    private int size = 0;
    private int[] items = new int[capacity];

    public void convertToMaxHeap() {
        for (int i = size - 1; i >= 0; i--) {
            maxifyHeap(i);
        }
    }

    private void maxifyHeap(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        int largest = index;

        if (hasLeftChild(index) && items[leftIndex] > items[largest]) {
            largest = leftIndex;
        }
        if (hasRightChild(index) && items[rightIndex] > items[largest]) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(largest, index);

            // move up
            maxifyHeap(largest);
        }
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return items[0];
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();

        return item;
    }

    private void heapifyDown() {
        // start with root element
        int index = 0;

        // as long as I have children, keep walking down and fix up my heap
        // we check with left child because if there no left child, there's no way to have right child
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break; // parent < leftChild, heap is fixed
            } else {
                swap(index, smallerChildIndex);
            }
            // move down to smaller child
            index = smallerChildIndex;
        }
    }

    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        // begin with last element
        int index = size - 1;

        // if this item has parent and parent is bigger than new child
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void swap(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public void printHeap() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", items[i]);
        }
        System.out.printf("]\n");
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    private boolean hasParent(int index) {
        if (index == 0) return false;
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int parentIndex) {
        return items[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return items[getRightChildIndex(parentIndex)];
    }

    private int parent(int childIndex) {
        return items[getParentIndex(childIndex)];
    }

    public int getSize() {
        return size;
    }
}
