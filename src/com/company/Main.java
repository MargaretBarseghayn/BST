package com.company;

public class Main {

    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(60);
        bst.add(20);
        bst.add(30);
        bst.add(90);
        bst.add(75);
        bst.add(70);
        bst.add(110);
        bst.add(100);

        bst.DFS();
        bst.BFS();

        System.out.println(bst.search(5));
        System.out.println(bst.search(1));

        bst.delete(60);
        bst.BFS();

    }
}
