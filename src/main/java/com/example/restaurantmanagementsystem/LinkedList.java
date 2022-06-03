package com.example.restaurantmanagementsystem;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedList<T> {

    Node<T> head;

    private int length = 0;

    LinkedList() { this.head = null; }

    // To add node at the end of List
    void add(T data){
        Node<T> temp = new Node<>(data);

        if (this.head == null)
            head = temp;
        else {
            Node<T> X = head;

            while (X.next != null)
                X = X.next;

            X.next = temp;
        }
        length++;
    }

    // To add new node at any given position
    void add(int position, T data){

        // Checking if position is valid
        if (position > length + 1) {
            System.out.println("Position Unavailable in LinkedList");
            return;
        }

        // If new position is head then replace head node
        if (position == 1) {
            Node<T> temp = head;

            head = new Node<T>(data);
            head.next = temp;

            return;
        }
        Node<T> temp = head;
        Node<T> prev = new Node<T>(null);
        while (position - 1 > 0) {
            prev = temp;
            temp = temp.next;
            position--;
        }
        prev.next = new Node<T>(data);
        prev.next.next = temp;
    }

    // To remove a node from list
    void remove(T key){
        // Dummy node with null value
        Node<T> prev = new Node<>(null);

        prev.next = head;
        Node<T> next = head.next;
        Node<T> temp = head;

        boolean exists = false;

        // If head node needs to be deleted
        if (head.data == key) {
            head = head.next;

            // Node to be deleted exists
            exists = true;
        }

        // Iterating over LinkedList
        while (temp.next != null) {
            // Comparing value of key and current node
            if (String.valueOf(temp.data).equals(String.valueOf(key))) {
                prev.next = next;
                exists = true;
                break;
            }
            prev = temp;
            temp = temp.next;
            next = temp.next;
        }

        // Comparing the last node with the given key value
        if (!exists && String.valueOf(temp.data).equals(String.valueOf(key))) {
            prev.next = null;
            exists = true;
        }
        // If node to be deleted exists
        if (exists)
            length--;
            // If node to be deleted does not exist
        else
            System.out.println("Given Value is not present in linked list");

    }

    public T get(int index){
        if(index < 0 || index > this.length)
            throw new IndexOutOfBoundsException();

        Node<T> current = this.head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.data; //Since we are working with generics, we need to return a type E, and it needs to be in parenthesis so it gets that object.
    }

    // To clear the entire LinkedList
    void clear(){
        head = null;
        length = 0;
    }

    // Returns whether List is empty or not
    boolean empty(){
        return head == null;
    }

    // Returning the length of LinkedList
    int length() { return this.length; }

    // To display the LinkedList
    // @Override
    public String toString(){

        StringBuilder S = new StringBuilder("{ ");

        Node<T> X = head;

        if (X == null)
            return S + " }";

        while (X.next != null) {
            S.append(String.valueOf(X.data)).append(" -> ");
            X = X.next;
        }

        S.append(String.valueOf(X.data));
        return S + " }";
    }
}