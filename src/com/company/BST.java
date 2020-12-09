package com.company;

import java.util.LinkedList;
import java.util.Stack;

public class BST {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public boolean search(int value) {
        Node current = root;
        while (current != null && current.value != value)
            current = (current.value < value ? current.right : current.left);
        return current != null;
    }

    public void delete(int value) {
        if (root == null)
            return;
        Node parent = null;
        Node current = root;
        while (current != null && current.value != value) {
            parent = current;
            current = (current.value < value ? current.right : current.left);
        }
        if (current == null)
            return;

        if (current.left == null && current.right == null) {
            if (parent == null) {
                root = null;
            } else if (parent.right == current) {
                parent.right = null;
            } else {
                parent.left = null;
            }
            return;
        }

        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else if (parent.right == current) {
                parent.right = current.right;
            } else {
                parent.left = current.right;
            }
        } else if (current.right == null) {
            if (parent == null) {
                root = current.left;
            } else if (parent.right == current) {
                parent.right = current.left;
            } else {
                parent.left = current.left;
            }
        } else {
            parent = current;
            Node temp = current.right;
            while (temp.left != null) {
                parent = temp;
                temp = temp.left;
            }
            current.value = temp.value;
            if (parent.left == temp) {
                parent.left = null;
            } else {
                parent.right = temp.right;
            }
        }
    }

    private Node min(Node t) {
        if (t == null)
            return null;
        if (t.left == null)
            return t;
        while (t.left != null) {
            t = t.left;
        }

        return t;
    }

    //    private Node deleteRecursive(Node current, int value){
//        if(current == null)
//            return null;
//        if (value == current.value) {
//
//        }
//        if (value < current.value) {
//            current.left = deleteRecursive(current.left, value);
//            return current;
//        }
//        current.right = deleteRecursive(current.right, value);
//        return current;
//    }

    public void DFS() {
        Node vertex = this.root;
        Stack<Node> s = new Stack<>();
        while (true) {
            if (vertex != null) {
                s.push(vertex);
                vertex = vertex.left;
            } else {
                if (s.empty()) {
                    System.out.println();
                    return;
                }

                System.out.print(s.peek().value + " ");
                vertex = s.pop().right;
            }
        }
    }

    public void BFS() {
        LinkedList<Node> list = new LinkedList<>();
        list.add(this.root);
        while (!list.isEmpty()) {
            Node temp = list.remove();
            System.out.print(temp.value + " ");
            if (temp.left != null) {
                list.add(temp.left);
            }
            if (temp.right != null) {
                list.add(temp.right);
            }
        }
        System.out.println();
    }
}
