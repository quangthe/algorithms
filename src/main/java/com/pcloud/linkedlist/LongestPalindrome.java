package com.pcloud.linkedlist;

/**
 *
 */
public class LongestPalindrome {
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    private ListNode head;

    public LongestPalindrome() {
        this.head = null;
    }

    public void insertAtFront(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public int maxPalindrome() {
        ListNode previous = null;
        ListNode current = head;

        int max = 0;
        while (current != null) {
            // keep track next node
            ListNode next = current.next;

            // reverse current node
            current.next = previous;

            // count palindrome
            max = Math.max(max, 2 * countCommon(current, next));  // even palindrome
            max = Math.max(max, 2 * countCommon(previous, next) + 1); // odd palindrome

            // move to next node
            previous = current;
            current = next;
        }
        return max;
    }

    private int countCommon(ListNode left, ListNode right) {
        ListNode a = left;
        ListNode b = right;
        int count = 0;
        while (a != null && b != null) {
            if (a.data != b.data) {
                break;
            } else {
                count++;
                a = a.next;
                b = b.next;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LongestPalindrome ll = new LongestPalindrome();

        int[] input1 = new int[] {24, 12, 2, 3, 7, 3, 2};
        for (int i = 0; i < input1.length; i++) {
            ll.insertAtFront(input1[i]);
        }
        System.out.println(ll.maxPalindrome());

        int[] input2 = new int[] {14, 3, 4, 4, 12};
        ll = new LongestPalindrome();
        for (int i = 0; i < input2.length; i++) {
            ll.insertAtFront(input2[i]);
        }
        System.out.println(ll.maxPalindrome());
    }
}
