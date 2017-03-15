package com.pcloud.search;

import java.util.TreeSet;

/**
 * Created by thetran on 3/8/17.
 */
public class HackerLandRadioTransmitter {
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        int x[] = new int[]{1, 2, 7, 34, 9, 12, 18, 21};

        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(x[i]);
        }
        int count = 0;
        int reference = set.first();
        System.out.println(set);
        while (true) {
            if ((set.last() - reference) <= k) {
                count++;
                break;
            }
            reference = set.floor(reference + k);
            count++;
            System.out.println("a"+reference);
            if (set.higher(reference + k) != null) {
                reference = set.higher(reference + k);
            } else {
                break;
            }
            System.out.println("b"+reference);
        }
        System.out.println(count);
    }

}
