package com.pcloud.search;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 */
public class SubArrayModuloProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt();
            long k = scanner.nextLong();
            long[] a = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextLong();
            }
            long result = maxModulo(a, k);
            System.out.println(result);
        }
    }

    public static long maxModulo(long[] a, final long k) {
        long[] s = new long[a.length];
        s[0] = a[0] % k;
        long result = s[0];

        TreeSet<Long> tree = new TreeSet<>();
        tree.add(s[0]);

        for (int i = 1; i < a.length; i++) {
            s[i] = (s[i - 1] + a[i]) % k;
            Long v = tree.higher(s[i]);
            if (v == null) {
                result = Math.max(s[i], result);
            } else {
                result = Math.max((s[i] - v + k) % k, result);
            }
            tree.add(s[i]);
        }
        return result;
    }
}
