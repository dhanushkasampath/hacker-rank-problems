package com.code.practise.hackerrankproblems.data_structures.linked_lists.insert_node_to_a_sorted_doubly_linked_list;

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

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        // Write your code here
        DoublyLinkedListNode node = llist;
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (llist == null) {
            return newNode;
        } else {
            while(node.data < data){
               if(node.next == null){
                   break;
               } else {
                   node = node.next;
               }
            }

            if(node.next == null) {//coming here means we need to set node to tail
                if(data < node.data ){//coming to here means we are going to add the new node after the head node and before to the tail node
                    node = node.prev;
                    newNode.prev = node;
                    newNode.next = node.next;
                    node.next = newNode;
                } else {
                    node.next = newNode;// //coming to here means we are going to add the new node before to the tail node
                    newNode.prev = node;
                }
                return llist;
            }

            if (node.prev == null) {//coming here means we are going to add the new node before current head node
                newNode.next = node;
                node.prev = newNode;
                return newNode;

            } else {
                node = node.prev;
                newNode.prev = node;
                newNode.next = node.next;
                node.next = newNode;
                return llist;
            }
        }
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

//        int[] arr = {33, 33, 38, 41, 48, 56, 68, 71, 76, 90};//this is a sorted array  //1
//        int[] arr = {1, 2, 4};//this is a sorted array  //2
//        int[] arr = {2, 3, 4};//this is a sorted array  //3
//         int[] arr = {1, 2, 3};//this is a sorted array  //4
        int[] arr = {1, 3, 4, 10};//this is a sorted array  //5
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        for (int i : arr) {
            doublyLinkedList.insertNode(i);
        }

        printLinkedList(doublyLinkedList.head);

//        DoublyLinkedListNode updatedDoublyLinkedListNode = Result.sortedInsert(doublyLinkedList.head, 40);  //1
//        DoublyLinkedListNode updatedDoublyLinkedListNode = Result.sortedInsert(doublyLinkedList.head, 3);  //2
//        DoublyLinkedListNode updatedDoublyLinkedListNode = Result.sortedInsert(doublyLinkedList.head, 1);  //3
//        DoublyLinkedListNode updatedDoublyLinkedListNode = Result.sortedInsert(doublyLinkedList.head, 4);  //4
        DoublyLinkedListNode updatedDoublyLinkedListNode = Result.sortedInsert(doublyLinkedList.head, 5);  //5

        printLinkedList(updatedDoublyLinkedListNode);
    }
}
