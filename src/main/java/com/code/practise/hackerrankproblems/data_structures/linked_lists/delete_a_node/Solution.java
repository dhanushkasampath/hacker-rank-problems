package com.code.practise.hackerrankproblems.data_structures.linked_lists.delete_a_node;

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

    // int[] arr = {38, 76, 33, 56, 90, 33, 71, 41, 48, 68};
    static SinglyLinkedListNode deleteNodeAtPosition(SinglyLinkedListNode headNode, int position) {

        if(position == 0){
            return headNode.next;

        }else{
            SinglyLinkedListNode n = headNode;//linked list is 0 based
            for(int i=0;i<position-1;i++){//traversing through nodes
                n = n.next;//position-1 means the node before the deletable node
            }
            SinglyLinkedListNode deletable = n.next;
            n.next = deletable.next;
            return headNode;
        }
    }

    public static void main(String[] args) {
        // Assume we need to add this data to linked list.
        int[] arr = {38, 76, 33, 56, 90, 33, 71, 41, 48, 68};
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        for (int i : arr) {
            singlyLinkedList.insertNode(i);
        }

        printLinkedList(singlyLinkedList.head);

        deleteNodeAtPosition(singlyLinkedList.head, 4);//to delete the new node at 4th index

        printLinkedList(singlyLinkedList.head);
    }
}
