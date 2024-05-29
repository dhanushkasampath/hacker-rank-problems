package com.code.practise.hackerrankproblems.data_structures.heap.QHEAP1;

import java.util.Scanner;

public class Solution {

    public static class Heap {

        private int MAX_size = 100000;
        private int[] arr = new int[MAX_size + 1];
        private int size;

        public Heap() {
            size = 0;
        }

        public boolean isEmpty() {
            return size <= 0;
        }

        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Error: Heap is empty");
            }
            return arr[1];
        }

        public void swap(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public void add(int value) {

            size++;
            arr[size] = value;
            int curIndex = size;
            int parentIndex = curIndex / 2;
            while (arr[parentIndex] > arr[curIndex] && parentIndex != 0) {
                swap(parentIndex, curIndex);
                curIndex = parentIndex;
                parentIndex = curIndex / 2;
            }
        }

        public int poll() {
            if (isEmpty()) {
                throw new RuntimeException("Error: Heap is empty");
            }
            int value = arr[1];
            arr[1] = arr[size];
            size--;
            heapifyDown(1);
            return value;
        }

        public void remove(int value) {
            int curIndex = -1;
            for (int i = 1; i <= size; i++) {
                if (arr[i] == value) {
                    curIndex = i;
                    break;
                }
            }
            if (curIndex == -1) {
                throw new RuntimeException("Error: Not found");
            }
            arr[curIndex] = arr[size];
            size--;
            // heapify
            heapifyDown(curIndex);
        }

        private void heapifyDown(int curIndex) {
            while ((2 * curIndex) <= size) {
                int leftChildIndex = 2 * curIndex;
                int rightchildIndex = leftChildIndex + 1;
                int smallerChildIndex = leftChildIndex;
                if (rightchildIndex <= size && arr[rightchildIndex] < arr[leftChildIndex]) {
                    smallerChildIndex = rightchildIndex;
                }
                if (arr[curIndex] > arr[smallerChildIndex]) {
                    swap(curIndex, smallerChildIndex);
                    curIndex = smallerChildIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q > 0) {
            int choice = sc.nextInt();
            switch (choice) {
                // add
                case 1:
                    heap.add(sc.nextInt());
                    break;
                // delete
                case 2:
                    heap.remove(sc.nextInt());
                    break;
                //print minimum
                case 3:
                    System.out.println(heap.peek());
                    break;
            }
            q--;
        }
    }
}
