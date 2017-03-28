package com.pcloud.heap;

/**
 * Created by thetran on 3/28/17.
 */
public class DemoMaxHeap {
    public static void main(String[] args) {
        MaxIntHeap heap = new MaxIntHeap();
        int[] a = new int[] {1, 23, 56, 11, 45, 2, 57, 64, 89, 50, 25, 72};

        for (int i = 0; i < a.length; i++) {
            heap.add(a[i]);
        }

        while (heap.getSize() > 0) {
            int max = heap.poll();
            System.out.printf("Poll heap: %d\n", max);
        }
    }
}
