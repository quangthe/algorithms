package com.pcloud.linkedlist;

/**
 *
 */
public class CheckLinkedListPalindrome {
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ListNode{");
            sb.append("data=").append(data);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }

    private ListNode head;

    public void insertAtFront(int value) {
        ListNode newNode = new ListNode(value);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.printf("%d --> ", current.data);
            current = current.next;
        }
        System.out.println(" NULL");
    }

    public boolean isPalindrome() {
        if (head == null) {
            // edge case
            return false;
        }
        if (head.next == null) {
            // edge case
            return true;
        }


        ListNode fast = head;

        ListNode current = head;
        ListNode previous = null;

        while (fast!= null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }

            // keep track next node
            ListNode next = current.next;

            // reverse current node
            current.next = previous;

            // move to next node
            previous = current;
            current = next;
        }

        if (isPalindrome(previous, current)) {
            return true;
        }
        if (isPalindrome(previous.next, current)) {
            return true;
        }
        return false;
    }

    private boolean isPalindrome(ListNode rev, ListNode fwd) {
        ListNode a = rev;
        ListNode b = fwd;

        while (a != null && b != null) {
            if (a.data != b.data) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        if (a != null || b != null) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CheckLinkedListPalindrome ll = new CheckLinkedListPalindrome();
        int[] a = new int[] {99, 1, 2, 3, 4, 4, 3, 2, 1, 99};
        for (int i = 0; i < a.length; i++) {
            ll.insertAtFront(a[i]);
        }

        ll.printList();

        System.out.printf("Is Palindrome: %s\n", ll.isPalindrome());
    }
}
