package com.pcloud.linkedlist;

/**
 *
 */
public class SingleLinkedList<T> {
    public static class ListNode<T> {
        public T data;
        public ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
        }
    }

    private ListNode<T> head;
    private ListNode<T> tail;

    public SingleLinkedList() {
        head = tail = null;
    }

    public void reverse() {
        ListNode<T> previous = null;
        ListNode<T> next = null;

        ListNode<T> current = head;
        tail = head;

        while (current != null) {
            // keep track next node
            next = current.next;

            // reverse current node
            current.next = previous;

            // keep track previous node
            previous = current;

            // move to next node
            current = next;
        }
        head = previous;
    }

    public void insertAtFront(T value) {
        ListNode<T> newNode = new ListNode<>(value);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtBack(T value) {
        ListNode<T> newNode = new ListNode<>(value);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T removeAtFront() throws LinkedListEmptyException {
        if (head == null) {
            throw new LinkedListEmptyException("Single Linked List is empty");
        }

        T data = head.data;

        ListNode<T> removedNode = head;
        head = head.next;
        removedNode.next = null;

        return data;
    }

    public T removeAtBack() throws LinkedListEmptyException {
        if (tail == null) {
            throw new LinkedListEmptyException("Single Linked List is empty");
        }

        if (head == tail) {
            T data = tail.data;
            head = tail = null;
            return data;
        }

        // find parent of tail
        ListNode<T> parent = head;
        while (parent.next != tail) {
            parent = parent.next;
        }

        T data = tail.data;

        tail = parent;
        tail.next = null;

        return data;
    }

    public T removeAtBack2() throws LinkedListEmptyException {
        if (head == null) {
            throw new LinkedListEmptyException("Single Linked List is empty");
        }

        ListNode<T> previous = null;
        ListNode<T> current = head;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        T data = current.data;

        if (previous == null) {
            head = tail = null;
        }
        else {
            tail = previous;
            tail.next = null;
        }
        return data;
    }

    public void printList() {
        ListNode<T> current = head;
        while (current != null) {
            System.out.printf("%s --> ", current.data);
            current = current.next;
        }
        System.out.println(" NULL");
    }

    public static void main(String[] args) throws LinkedListEmptyException {
        SingleLinkedList<Integer> ll = new SingleLinkedList<>();

        ll.insertAtFront(4);
        ll.insertAtFront(9);

        ll.insertAtBack(12);
        ll.insertAtBack(57);

        ll.printList();

        ll.reverse();
        ll.printList();

//        System.out.printf("Remove at front %s\n", ll.removeAtFront());
//        ll.printList();
//
//        System.out.printf("Remove at back %s\n", ll.removeAtBack());
//        ll.printList();
//
//        System.out.printf("Remove at back %s\n", ll.removeAtBack2());
//        ll.printList();
//
//        System.out.printf("Remove at back %s\n", ll.removeAtBack2());
//        ll.printList();
//
//        ll.removeAtBack2();
//        ll.printList();
    }
}
