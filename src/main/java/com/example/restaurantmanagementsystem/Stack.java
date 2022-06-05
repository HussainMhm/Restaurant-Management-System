package com.example.restaurantmanagementsystem;

public class Stack {

    StackNode root;
    private int size = 0;

    // Node class for stack
    static class StackNode {
        Food data;
        StackNode next;

        StackNode(Food data) { this.data = data; }
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Add new node to stack
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

    // Return and delete node on top of stack
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

    // Return the node on top of stack
    public Food peek() {
        if (root == null) {
            return null;
        }
        else {
            return root.data;
        }
    }

    // Get size of stack
    public int getSize(){
        return size;
    }
}
