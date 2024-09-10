//package org.srini;
//
////implement the code
//class Node {
//    int key;
//    DataNode left, right;
//
//    public Node(int item) {
//        key = item;
//        left = right = null;
//    }
//}
//
//public class BinarySearchTreeDemo {
//    DataNode root;
//
//    BinarySearchTreeDemo() {
//        root = null;
//    }
//
//    void insert(int key) {
//        root = insertRec(root, key);
//    }
//
//    DataNode insertRec(DataNode root, int key) {
//        if (root == null) {
//            root = new DataNode(key);
//            return root;
//        }
//
//        if (key < root.key) {
//            root.left = insertRec(root.left, key);
//        } else if (key > root.key) {
//            root.right = insertRec(root.right, key);
//        }
//
//        return root;
//    }
//
//    void inorder() {
//        inorderRec(root);
//    }
//
//    void inorderRec(DataNode root) {
//        if (root != null) {
//            inorderRec(root.left);
//            System.out.print(root.key + " ");
//            inorderRec(root.right);
//        }
//    }
//
//    private static void printTree(DataNode dataNode, int depth) {
//        if (dataNode == null) {
//            return;
//        }
//
//        printTree(dataNode.right, depth + 1);
//
//        for (int i = 0; i < depth; i++) {
//            System.out.print("    ");
//        }
//
//        System.out.println(dataNode.key);
//
//        printTree(dataNode.left, depth + 1);
//    }
//
//    public static void print(DataNode root) {
//        printTree(root, 0);
//    }
//
//    public static void main(String[] args) {
//        BinarySearchTreeDemo tree = new BinarySearchTreeDemo();
//
//        tree.insert(50);
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(40);
//        tree.insert(70);
//        tree.insert(60);
//        tree.insert(80);
//
//        tree.inorder();
//
//        print(tree.root);
//    }
//}
//
