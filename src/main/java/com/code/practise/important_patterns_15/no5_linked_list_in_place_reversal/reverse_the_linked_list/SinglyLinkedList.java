package com.code.practise.important_patterns_15.no5_linked_list_in_place_reversal.reverse_the_linked_list;


public class SinglyLinkedList {

    SinglyLinkedListNode head;
    SinglyLinkedListNode tail;

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
            node.prev = this.tail;
        }

        this.tail = node;
    }
}
