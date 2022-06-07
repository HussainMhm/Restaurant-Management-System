package com.example.restaurantmanagementsystem;

public class BinaryTree {

    public class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString(){
            return "Node = " + value;
        }
    }

    private Node root;

    //Insert new node
    public void insert(int value){
        Node node = new Node(value);

        if(root == null){
            root = new Node(value);
            return;
        }

        Node current = root;

        while (true){
            if(value < current.value){
                if(current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else {
                if(current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    //Check if node is there
    public boolean find(int value){
        Node current = root;

        while (current != null){
            if(value < current.value)
                current = current.leftChild;
            else if(value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    //Height
    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root == null)
            return -1;

        if (root.leftChild == null && root.rightChild == null)
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    //Depth
    public int depth(){
        return depth(root);
    }
    private int depth(Node root){
        if(root == null)
            return -1;

        int leftDepth = depth(root.leftChild);
        int rightDepth = depth(root.rightChild);

        if(leftDepth > rightDepth)
            return (leftDepth + 1);
        else
            return (rightDepth + 1);
    }

    //Node count
    public int countNode(){
        return countNode(root);
    }
    private int countNode(Node root){
        if(root == null)
            return 0;

        return 1 + countNode(root.leftChild) + countNode(root.rightChild);
    }

    //Leaf count
    public int countLeaf(){
        return countLeaf(root);
    }
    private int countLeaf(Node root){
        if(root == null)
            return 0;
        else if(root.leftChild == null && root.rightChild == null)
            return 1;
        else
            return countLeaf(root.leftChild) + countLeaf(root.rightChild);

    }

    //Child count
    public int countChild(){
        return countChild(root);
    }
    private int countChild(Node root){
        return countNode(root) - 1;
    }

    //Smallest node
    public int smallestNode(){
        Node current = root;

        while(current.leftChild != null){
            current = current.leftChild;
        }
        return current.value;
    }
//    private int smallestNode(Node root){
//        if(root == null)
//            return -1;
//
//        if(root.rightChild == null && root.leftChild == null)
//            return root.value;
//
//        int left = smallestNode(root.leftChild);
//        int right = smallestNode(root.rightChild);
//
//        return Math.min(Math.min(left, right), root.value);
//    }

    //Traversing Tree
    public void traversePreOrder(){
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root){
        if(root == null)
            return;

        System.out.println(root.value);
        traverseInOrder(root.leftChild);
        traverseInOrder(root.rightChild);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root){
        if(root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root){
        if(root == null)
            return;

        traverseInOrder(root.leftChild);
        traverseInOrder(root.rightChild);
        System.out.println(root.value);
    }
}
