package org.task4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        try (Scanner scan = new Scanner(System.in)) {
            char ch;
            do {
                System.out.println("Введите целое число");

                int num = scan.nextInt();
                tree.insert(num);

                tree.inorder();
                System.out.println("\nВы хотите продолжить? (введите y или n)");
                ch = scan.next().charAt(0);
            } while (ch == 'Y' || ch == 'y');
        }
    }
}

class Node {

    Node left, right;
    int data;
    boolean color;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
        color = true;
    }
}

class RedBlackTree {

    private static Node root = null;

    private Node rotateLeft(Node myNode) {
        System.out.print("Поворот влево\n");
        Node child = myNode.right;
        Node childLeft = child.left;

        child.left = myNode;
        myNode.right = childLeft;

        return child;
    }

    private Node rotateRight(Node myNode) {
        System.out.print("Поворот вправо\n");
        Node child = myNode.left;
        Node childRight = child.right;

        child.right = myNode;
        myNode.left = childRight;

        return child;
    }

    private boolean isRed(Node myNode) {
        if (myNode == null) {
            return false;
        }
        return myNode.color;
    }

    private void swapColors(Node node1, Node node2) {
        boolean temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    private Node insert(Node myNode, int data) {
        if (myNode == null) {
            return new Node(data);
        }

        if (data < myNode.data) {
            myNode.left = insert(myNode.left, data);
        } else if (data > myNode.data) {
            myNode.right = insert(myNode.right, data);
        } else {
            return myNode;
        }

        if (isRed(myNode.right) && !isRed(myNode.left)) {
            myNode = rotateLeft(myNode);
            swapColors(myNode, myNode.left);
        }

        if (isRed(myNode.left) && isRed(myNode.left.left)) {
            myNode = rotateRight(myNode);
            swapColors(myNode, myNode.right);
        }

        if (isRed(myNode.left) && isRed(myNode.right)) {
            myNode.color = !myNode.color;
            myNode.left.color = false;
            myNode.right.color = false;
        }

        return myNode;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            char c = '●';
            if (!node.color)
                c = '◯';
            System.out.print(node.data + "" + c + " ");
            inorder(node.right);
        }
    }

    public void inorder() {
        inorder(root);
    }
}