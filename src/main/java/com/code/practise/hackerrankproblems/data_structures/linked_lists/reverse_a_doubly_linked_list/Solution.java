package com.code.practise.hackerrankproblems.data_structures.linked_lists.reverse_a_doubly_linked_list;

import java.io.IOException;

class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }
}

class Result {

    /*
     * Complete the 'sortedInsert' function below.
     *
     * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_DOUBLY_LINKED_LIST llist
     *  2. INTEGER data
     */

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = null;
        DoublyLinkedListNode current = head;

        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        /* Before changing head, check for the cases like
         empty list and list with only one node */
        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

}

public class Solution {

    static void printLinkedList(DoublyLinkedListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while ( head != null) {
            stringBuilder.append(head.data);
            stringBuilder.append(" -> ");
            head = head.next;
        }
        System.out.println(stringBuilder
                .substring(0, stringBuilder.toString().length()-4));
    }

    public static void main(String[] args) throws IOException {

        int[] arr = {33, 33, 38, 41, 48, 56, 68, 71, 76, 90};//this is a sorted array
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        for (int i : arr) {
            doublyLinkedList.insertNode(i);
        }

        printLinkedList(doublyLinkedList.head);

        DoublyLinkedListNode reversedDoublyLinkedListNode = Result.reverse(doublyLinkedList.head);

        printLinkedList(reversedDoublyLinkedListNode);
    }
}
