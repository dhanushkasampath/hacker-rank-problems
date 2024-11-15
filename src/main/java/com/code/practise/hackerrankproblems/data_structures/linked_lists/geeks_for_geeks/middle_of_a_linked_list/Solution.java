package com.code.practise.hackerrankproblems.data_structures.linked_lists.geeks_for_geeks.middle_of_a_linked_list;

/**

 The idea is to traverse the entire linked list once to count the total number of nodes. After determining the total
 count, traverse the list again and stop at the (count/2)th node to return its value. This method requires two passes
 through the linked list to find the middle element.

  */
public class Solution {

    private static int getLength(Node head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }

        return length;
    }

    public static int getMiddleNode(Node head){
        int length = getLength(head);

        int midIndex = length/2;

        while(midIndex > 0){
            head = head.next;
            midIndex--;
        }
        return head.data;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        System.out.println(getMiddleNode(head));
    }

}
