package com.code.practise.important_patterns_15.no5_linked_list_in_place_reversal.reverse_the_linked_list;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {38, 76, 33, 56, 90, 33, 71, 41, 48, 68};
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for(int i : arr){
            singlyLinkedList.insertNode(i);
        }
        printLinkedList(singlyLinkedList.head);

        SinglyLinkedListNode reversedLinkedListNode = reverseTheLinkedList(singlyLinkedList.head);
        printLinkedList(reversedLinkedListNode);
    }

    static void printLinkedList(SinglyLinkedListNode head) {
        StringBuilder stringBuilder = new StringBuilder();// Keep in mind that StringBuilder is not thread safe.
        // So it is faster than StringBuffer
        while ( head != null) {
            stringBuilder.append(head.data);
            stringBuilder.append(" -> ");
            head = head.next;
        }
        System.out.println(stringBuilder
                .substring(0, stringBuilder.toString().length()-4)); // This is to remove " -> " that gets printed at the end
    }

    static SinglyLinkedListNode reverseTheLinkedList(SinglyLinkedListNode head){

        SinglyLinkedListNode temp = null;
        SinglyLinkedListNode current = head;

        while(current != null){
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
