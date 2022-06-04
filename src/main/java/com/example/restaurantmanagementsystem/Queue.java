package com.example.restaurantmanagementsystem;

public class Queue {
    private int size = 50;
    private Order[] arr = new Order[size];      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity = size;   // maximum capacity of the queue
    private int count;      // current size of the queue

    Queue() {
        front = 0;
        rear = -1;
        count = 0;
    }

    public Order dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }

        Order x = arr[front];
        front = (front + 1) % capacity;
        count--;

        return x;
    }

    public void enqueue(Order item) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(-1);
        }

        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    public Order peek() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        return arr[front];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public boolean isFull() {
        return (size() == capacity);
    }
}
