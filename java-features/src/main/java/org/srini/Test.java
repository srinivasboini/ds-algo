package org.srini;
import java.util.Comparator;

// Definition of a Node in Binary Search Tree (BST) data structure
class Node2 {
    int key;
    String value;
    Node2 left, right;

    // Constructor to create a new node with the given key and value
    public Node2(int key, String value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }
}

// Binary Search Tree implementation
class BST {

    // Comparator to compare keys in the BST
    Comparator<Integer> comparator = Integer::compare;

    // Root node of the BST
    Node2 root;

    // Constructor to initialize an empty tree
    public BST() {
        root = null;
    }

    // Insert a new key-value pair into the BST
    public void insert(int key, String value) {
        root = insertRecursive(root, key, value);
    }

    // Recursive helper function for inserting a new node in the BST
    private Node2 insertRecursive(Node2 node, int key, String value) {

        if (node == null) {
            return new Node2(key, value);
        }

        if (comparator.compare(key, node.key) < 0) {
            node.left = insertRecursive(node.left, key, value);
        } else if (comparator.compare(key, node.key) > 0) {
            node.right = insertRecursive(node.right, key, value);
        } else {
            // Key already exists in the BST
            node.value = value;
        }

        return node;
    }

    // Search for a given key in the BST and return its associated value
    public String search(int key) {
        return searchRecursive(root, key);
    }

    // Recursive helper function for searching a key in the BST
    private String searchRecursive(Node2 node, int key) {

        if (node == null || node.key == key) {
            return node == null ? null : node.value;
        }

        if (comparator.compare(key, node.key) < 0) {
            return searchRecursive(node.left, key);
        } else {
            return searchRecursive(node.right, key);
        }
    }
}
public class Test {

    public static void main(String[] args) {

        BST bst = new BST();

        // Add some elements to the BST
        bst.insert(5, "apple");
        bst.insert(3, "banana");
        bst.insert(7, "cherry");
        bst.insert(1, "date");
        bst.insert(9, "fig");

        // Search for some keys and print the corresponding values
        System.out.println("Value of key 5: " + bst.search(5));   // Output: apple
        System.out.println("Value of key 3: " + bst.search(3));   // Output: banana

        // Insert a new key-value pair with the same key as an existing element
        bst.insert(5, "orange");

        // Search for the updated value of key 5 and print it
        System.out.println("Updated Value of key 5: " + bst.search(5));   // Output: orange
    }
}

