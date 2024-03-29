package com.code.practise.hackerrankproblems.data_structures.linked_lists.cycle_detection;

import java.util.ArrayList;
import java.util.List;

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

    static boolean hasCycle(SinglyLinkedListNode head) {
        //get root value;
        if(head ==null) {
            return false;
        }

        boolean cyclFound=false;
        List<SinglyLinkedListNode> list = new ArrayList<>();

        while(head.next != null){
            if(list.contains(head)){
                cyclFound=true;
                break;
            }
            list.add(head);
            head = head.next;
        }
        return cyclFound;
    }

    public static void main(String[] args) {
        // Assume we need to add this data to linked list.
        int[] arr = {1, 2, 3, 1, 5};
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        for (int i : arr) {
            singlyLinkedList.insertNode(i);
        }

        printLinkedList(singlyLinkedList.head);

        System.out.println("Does linked list has cycle:" + hasCycle(singlyLinkedList.head));
    }
}
