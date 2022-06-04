package com.example.restaurantmanagementsystem;

public class Stack {

    StackNode root;
    private int size = 0;

    static class StackNode {
        Food data;
        StackNode next;

        StackNode(Food data) { this.data = data; }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void push(Food data) {
        StackNode newNode = new StackNode(data);

        if (root == null) {
            root = newNode;
        }
        else {
            StackNode temp = root;
            root = newNode;
            newNode.next = temp;
        }
        size++;
    }

    public Food pop() {
        Food popped = null;
        if (root == null) {
            System.out.println("Stack is Empty");
        }
        else {
            popped = root.data;
            root = root.next;
        }
        size--;
        return popped;
    }

    public Food peek() {
        if (root == null) {
            return null;
        }
        else {
            return root.data;
        }
    }

    public int getSize(){
        return size;
    }
}
