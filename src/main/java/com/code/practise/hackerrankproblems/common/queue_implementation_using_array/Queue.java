package com.code.practise.hackerrankproblems.common.queue_implementation_using_array;

public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    /**
     * This method will return the front element of the queue
     * @return int
     */
    public int peek(){
        return queueArray[front];
    }

    /**
     * This method will return whether queue is filled with elements or not
     * @return boolean
     */
    public boolean isQueueFull(){
        return maxSize == currentSize;
    }

    /**
     * This method will return whether queue is empty or not
     * @return boolean
     */
    public boolean isQueueEmpty(){
        return currentSize == 0;
    }

    /**
     * This method is used to add elements to the queue.
     * They are added from rear side of the queue
     */
    public int insert(int item){
        if(isQueueFull()){
            System.out.println("Queue is full. So can not add any more");
            return 1;
        }
        if(rear == maxSize - 1){
            rear = -1;
        }
        queueArray[++rear] = item;
        currentSize++;
        System.out.println("Item added to Queue successfully");
        return 0;
    }


    /**
     * This method is used to remove elements from the queue.
     * TODO - There is an issue with delete method. Fix that
     * @return
     */
    public int delete(){
        if(isQueueEmpty()){
            System.out.println("Queue is empty");
            return 0;
        }

        int dequeuedItem = queueArray[front];
        front = (front + 1) % maxSize; // Circular increment
        currentSize--;
        System.out.println("front element of queue removed successfully");
        return dequeuedItem;


//        int temp = queueArray[front++];
//        if(front == maxSize){
//            front = 0;
//        }
//        currentSize --;
//        System.out.println("front element of queue removed successfully");
//        return temp;
    }

    public void printQueue(){
        for(int s : queueArray){
            System.out.print(s + " ");
        }
    }
}
