package com.code.practise.important_patterns_15.no5_linked_list_in_place_reversal.reverse_the_linked_list;

// I have removed access modifiers. So it will be default now. So they are visible only in the package and classes.
//now outside the package
public class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode prev;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
