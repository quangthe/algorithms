package com.pcloud.string;

/**
 * Steve has a string, s, consisting of  lowercase English alphabetic letters.
 * In one operation, he can delete any pair of adjacent letters with same value.
 * For example, string "aabcc" would become either "aab" or "bcc" after operation.
 *
 * Steve wants to reduce  as much as possible.
 * To do this, he will repeat the above operation as many times as it can be performed.
 * Help Steve out by finding and printing 's non-reducible form!
 *
 * Note: If the final string is empty, print Empty String .
 */
public class SuperReducedStringSolution {
    public static void main(String[] args) {
        SuperReducedStringSolution solution = new SuperReducedStringSolution();

        String s = solution.reduce("baab");
        if (s.length() == 0) {
            System.out.println("Empty String");
        }
        System.out.println(s);
    }

    public String reduce(String s) {
        String s2 = s;
        while (s2.length() > 0) {
            s2 = reduceHelper(s);
            if (s.length() == s2.length()) {
                break;
            }
            s = s2;
        }
        return s2;
    }

    private static String reduceHelper(String s) {
        char[] a = s.toCharArray();

        int removedCharCount = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == ' ') continue;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == ' ') continue;
                if (a[i] == a[j]) {
                    a[i] = ' ';
                    a[j] = ' ';
                    removedCharCount += 2;
                }
                break;
            }
        }

        // remove ' ' element in array
        char[] newA = new char[a.length - removedCharCount];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ' ') continue;
            newA[j++] = a[i];
        }
        return String.valueOf(newA);
    }
}
