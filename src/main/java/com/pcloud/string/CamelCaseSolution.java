package com.pcloud.string;

/**
 * Alice wrote a sequence of words in CamelCase as a string of letters, s, having the following properties:
 *
 * It is a concatenation of one or more words consisting of English letters.
 * All letters in the first word are lowercase.
 * For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
 * Given s, print the number of words in  on a new line.
 */
public class CamelCaseSolution {
    public static void main(String[] args) {
        CamelCaseSolution solution = new CamelCaseSolution();
        String camel = "saveChangesInTheEditor";
        int count = solution.countWord(camel);
        System.out.println(count);
    }

    public int countWord(String camel) {
        char[] a = camel.toCharArray();
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (Character.isUpperCase(a[i])) {
                count++;
            }
        }
        return count;
    }
}
