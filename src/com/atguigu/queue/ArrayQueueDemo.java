package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): show queue");
            System.out.println("e(exit): exit queue");
            System.out.println("a(add): add data to queue");
            System.out.println("g(get): get data from queue");
            System.out.println("h(head): check the head of queue");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("Please add a data");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.printf("The data you get is %d\n", result);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = queue.headQueue();
                        System.out.printf("The front data is %d\n", result);
                    }catch ( Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }

        }
        System.out.println("You've exit the system.");
    }

    static class ArrayQueue {
        private int maxSize;
        private int front;
        private int rear;
        private int[] arr;

        public ArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = -1;
            rear = -1;

        }

        public boolean isFull() {
            return rear >= maxSize - 1;
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("The queue is full and can't add data anymore.");
                return;
            }
            rear++;
            arr[rear] = n;
        }

        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("The queue is empty, we can't get any data. ");
            }
            front++;
            return arr[front];
        }

        public void showQueue() {
            if (isEmpty()) {
                System.out.println("The queue is empty with no data to get.");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d] = %d\n", i, arr[i]);
            }

        }

        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("The queue is empty with no data to get.");
            }
            return arr[front + 1];
        }
    }
}
