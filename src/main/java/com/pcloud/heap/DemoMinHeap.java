package com.pcloud.heap;

/**
 * Created by thetran on 3/28/17.
 */
public class DemoMinHeap {
    public static void main(String[] args) {
        MinIntHeap heap = new MinIntHeap();
        int[] a = new int[] {98, 23, 56, 11, 45, 2, 57, 64, 89, 50, 25, 72};

        for (int i = 0; i < a.length; i++) {
            heap.add(a[i]);
        }
        System.out.println("Min Heap");
        heap.printHeap();

//        heap.convertToMaxHeap();
//
//        System.out.println("Convert to Max Heap");
//        heap.printHeap();

        while (heap.getSize() > 0) {
            int min = heap.poll();
            System.out.printf("Poll heap: %d\n", min);
        }
    }
}
