package com.code.practise.hackerrankproblems.common.queue_implementation_using_array;

public class Test {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.printQueue();
        queue.insert(5);
        queue.printQueue();
        queue.insert(2);
        queue.printQueue();
        queue.insert(6);
        queue.printQueue();
        queue.insert(9);
        queue.printQueue();
        queue.insert(1);
        queue.printQueue();
        queue.insert(3);
        queue.printQueue();
        queue.insert(7);
        queue.printQueue();
        queue.delete();
        queue.printQueue();
    }
}
