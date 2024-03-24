package com.code.practise.hackerrankproblems.data_structures.linked_lists.compare_two_linked_lists;

import java.util.Objects;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    // Complete the printLinkedList function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    //This is the code I have written
    static void printLinkedList(SinglyLinkedListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while ( head != null) {
            stringBuilder.append(head.data);
            stringBuilder.append(" -> ");
            head = head.next;
        }
        System.out.println(stringBuilder
            .substring(0, stringBuilder.toString().length()-4));
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode= new SinglyLinkedListNode(data);//creating the node tobe added

        if (head == null) {
            return newNode;
        } else {
            newNode.next = head;//set head as the next node of new node
            return newNode;
        }
    }

    public static void main(String[] args) {
        // Assume we need to add this data to linked list.
        int[] arr1 = {38, 76, 33, 56, 90, 33, 71, 41, 48, 68};
        int[] arr2 = {38, 76, 33, 56, 90, 33, 71, 41, 48, 68};
        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();

        for (int i : arr1) {
            singlyLinkedList1.insertNode(i);
        }

        for (int i : arr2) {
            singlyLinkedList2.insertNode(i);
        }

        printLinkedList(singlyLinkedList1.head);
        printLinkedList(singlyLinkedList2.head);

        System.out.println(compareLists(singlyLinkedList1.head, singlyLinkedList2.head));
    }

    private static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        /**
         * Below is the way I have done by string comparison. But I feel its not the optimum solution
         */
//        StringBuilder stringBuilder1 = new StringBuilder();
//
//        SinglyLinkedListNode singlyLinkedListNode1 = head1;
//        while(singlyLinkedListNode1.next != null) {
//            stringBuilder1.append(singlyLinkedListNode1.data);
//            singlyLinkedListNode1 = singlyLinkedListNode1.next;
//        }
//
//        SinglyLinkedListNode singlyLinkedListNode2 = head2;
//        StringBuilder stringBuilder2 = new StringBuilder();
//        while(singlyLinkedListNode2.next != null) {
//            stringBuilder2.append(singlyLinkedListNode2.data);
//            singlyLinkedListNode2 = singlyLinkedListNode2.next;
//        }
//
//        return stringBuilder1.toString().contentEquals(stringBuilder2);

        if(head1==null && head2==null)
            return true;

        boolean flag=true;
        while(head1!=null && head2!=null && head1.next!=null && head2.next!=null) {
            if(head1.data != head2.data) {
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }
        assert head1 != null;
        if(head1.next!=null || Objects.requireNonNull(head2).next!=null)
            return false;

        return flag;
    }
}
