package com.pcloud.linkedlist;

/**
 *
 */
public class LoopLinkedList {
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    private ListNode head;
    private ListNode tail;

    public void insertAtFront(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.printf("%d -> ", current.data);
            current = current.next;
        }
        System.out.println(" NULL");
    }

    public void detectAndRemoveLoop() {
        ListNode slow = head;
        ListNode fast = head.next;

        // check if loop exists or not
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // if loop exists
        if (slow == fast) {
            slow = head;
            while (slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            // since fast.next is the looping point
            fast.next = null; // remove loop
        }
    }

    public static void main(String[] args) {
        LoopLinkedList ll = new LoopLinkedList();
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < a.length; i++) {
            ll.insertAtFront(a[i]);
        }
        //ll.printList();

        // make loop
        ll.tail.next = ll.head.next.next;

        ll.detectAndRemoveLoop();
        ll.printList();
    }
}
