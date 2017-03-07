package com.pcloud.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/two-characters
 */
public class TwoCharacterSolution {
    public static void main(String[] args) {
        String s = "beabeefeab";

        TwoCharacterSolution solution = new TwoCharacterSolution();

        System.out.println(solution.solve(s));
    }

    public int solve(String s) {
        Set<Character> invalidChars = getInvalidChars(s);
        char[] a = s.toCharArray();

        for (Character c : invalidChars) {
            a = removeChar(a, c);
        }

        int maxLength = 0;
        String s2 = String.valueOf(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] != a[j]) {
                    int length = tryTwoCharacter(s2, a[i], a[j]);
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }

        return maxLength;
    }

    private int tryTwoCharacter(String s, char c1, char c2) {
        char[] a = s.toCharArray();
        int removedCharCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != c1 && a[i] != c2) {
                a[i] = ' ';
                removedCharCount++;
            }
        }
        // remove ' ' element in array
        char[] newA = new char[a.length - removedCharCount];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ' ') continue;
            newA[j++] = a[i];
        }
        if (isValidResult(newA)) {
            return newA.length;
        } else {
            return 0;
        }
    }

    private boolean isValidResult(char[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private Set<Character> getInvalidChars(String s) {
        Set<Character> invalidChars = new HashSet<>();
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                invalidChars.add(a[i]);
            }
        }
        return invalidChars;
    }

    private char[] removeChar(char[] a, char c) {
        int removedCharCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == c) {
                a[i] = ' ';
                removedCharCount++;
            }
        }

        // remove ' ' element in array
        char[] newA = new char[a.length - removedCharCount];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ' ') continue;
            newA[j++] = a[i];
        }
        return newA;
    }
}
