package com.code.practise.hackerrankproblems.data_structures.linked_lists.merge_two_sorted_linked_lists;

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

    public static void main(String[] args) {
        // Assume we need to add this data to linked list.
        int[] arr1 = {1, 3, 7};
        int[] arr2 = {1, 2};
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

        SinglyLinkedListNode mergedLinkedListHeadNode = mergeLinkedList(singlyLinkedList1.head, singlyLinkedList2.head);
        printLinkedList(mergedLinkedListHeadNode);
    }

    private static SinglyLinkedListNode mergeLinkedList(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        /**
        if (head1 == null && head2 != null) {// if one list is empty return the other list
            return head2;
        }

        if (head1 != null && head2 == null) {// if one list is empty return the other list
            return head1;
        }

        SinglyLinkedList mergedSinglyLinkedList = new SinglyLinkedList();
        SinglyLinkedListNode node = mergedSinglyLinkedList.head;
        while(head1.next!=null || head2.next!=null){

            if(head1.next!=null && head2.next!=null){

                if(head1.data == head2.data) {
                    mergedSinglyLinkedList.insertNode(head1.data);
                    mergedSinglyLinkedList.insertNode(head2.data);
                }

                if(head1.data < head2.data){
                    mergedSinglyLinkedList.insertNode(head1.data);
                    mergedSinglyLinkedList.insertNode(head2.data);
                }

                if(head1.data > head2.data){
                    mergedSinglyLinkedList.insertNode(head2.data);
                    mergedSinglyLinkedList.insertNode(head1.data);
                }

                head1=head1.next;
                head2=head2.next;
            }

            if(head1.next == null || head2.next == null){
                if(head1.data == head2.data) {
                    mergedSinglyLinkedList.insertNode(head1.data);
                    mergedSinglyLinkedList.insertNode(head2.data);
                }

                if(head1.data < head2.data){
                    mergedSinglyLinkedList.insertNode(head1.data);
                    mergedSinglyLinkedList.insertNode(head2.data);
                }

                if(head1.data > head2.data){
                    mergedSinglyLinkedList.insertNode(head2.data);
                    mergedSinglyLinkedList.insertNode(head1.data);
                }
            }

            if(head1.next != null && head2.next == null){
                node.next = head1.next;
                break;
            }

            if(head1.next == null && head2.next != null){
                node.next = head2.next;
                break;
            }

        }
        return mergedSinglyLinkedList.head;

         **/
        SinglyLinkedListNode temp = new SinglyLinkedListNode(0);

        SinglyLinkedListNode current = temp;

        if(head1 == null && head2 != null)return head2;
        if(head1!= null && head2 == null)return head1;

        while(head1 !=null && head2 != null){

            if(head1.data < head2.data){
                current.next = head1;
                head1= head1.next;
            }else{
                current.next = head2;
                head2= head2.next;
            }
            current = current.next;

        }
        current.next = head1 !=null ?head1:head2;

        return temp.next;
    }
}
