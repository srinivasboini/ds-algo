package org.srini;


// Define a simple binary tree node
class DataNode {
    int data;
    DataNode left, right;

    public DataNode(int item) {
        data = item;
        left = right = null;
    }
}

public class TreeTraversals {

    // In-order traversal
    void printInorder(DataNode dataNode) {
        if (dataNode == null)
            return;

        // First recur on left child
        printInorder(dataNode.left);

        // Then print the data of node
        System.out.print(dataNode.data + " ");

        // Now recur on right child
        printInorder(dataNode.right);
    }

    // Pre-order traversal
    void printPreorder(DataNode dataNode) {
        if (dataNode == null)
            return;

        // First print the data of node
        System.out.print(dataNode.data + " ");

        // Then recur on left child
        printPreorder(dataNode.left);

        // Finally recur on right child
        printPreorder(dataNode.right);
    }

    // Post-order traversal
    void printPostorder(DataNode dataNode) {
        if (dataNode == null)
            return;

        // First recur on left child
        printPostorder(dataNode.left);

        // Then recur on right child
        printPostorder(dataNode.right);

        // Now print the data of node
        System.out.print(dataNode.data + " ");
    }

    // Driver method
    public static void main(String[] args) {
        TreeTraversals tree = new TreeTraversals();
        DataNode root = new DataNode(1);
        root.left = new DataNode(2);
        root.right = new DataNode(3);
        root.left.left = new DataNode(4);
        root.left.right = new DataNode(5);

        System.out.println("Inorder traversal of binary tree is:");
        tree.printInorder(root);

        System.out.println("\nPreorder traversal of binary tree is:");
        tree.printPreorder(root);

        System.out.println("\nPostorder traversal of binary tree is:");
        tree.printPostorder(root);
    }
}
