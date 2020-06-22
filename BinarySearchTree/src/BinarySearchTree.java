import java.util.Random;

public class BinarySearchTree {
    public static void main(String[] args) {
        Node root = null;
        Tree bst = new Tree();
        final int SIZE = 2000000;
        int[] a = new int[SIZE];

        System.out.printf("Generating random array with %d values...%n", SIZE);

        Random random = new Random();
        long start = System.nanoTime();

        for (int i = 0; i < SIZE; i++) {
            a[i] = random.nextInt(10000);
        }

        long end = System.nanoTime();

        System.out.printf("Done. Took %f seconds%n%n", (double) ((end - start) / 1000000000.0));
        System.out.printf("Filling the tree with %d nodes...%n", SIZE);

        start = System.nanoTime();

        for (int i = 0; i < SIZE; i++) {
            root = bst.insert(root, a[i]);
        }

        end = System.nanoTime();

        System.out.printf("Done. Took %f seconds%n%n", (double) ((end - start) / 1000000000.0));
        System.out.printf("Traversing all %d nodes in tree...%n", SIZE);

        start = System.nanoTime();

        bst.traverse(root);

        end = System.nanoTime();

        System.out.printf("Done. Took %f seconds%n%n", (double) ((end - start) / 1000000000.0));
    }

    // Node
    private static class Node{
        // instance variables
        public int value; // the value stored within a node
        public Node leftLink; // reference to left child node
        public Node rightLink; // reference to right child node

        // node no arg constructor
        public Node(){
            value = 0;
            leftLink = null;
            rightLink = null;
        }

        // node full constructor
        public Node(int inputValue, Node inputLeftLink, Node inputRightLink) {
            value = inputValue;
            leftLink = inputLeftLink;
            rightLink = inputRightLink;
        }
    }

    // Tree Structure
    private static class Tree{

        // Insert a node
        public Node insert(Node root, int value) {
            // If a tree has no root create the root node
            if(root == null) {
                root = new Node();
                root.value = value;
            } else if(value < root.value) { // If new node value is less then root value insert new node left
                root.leftLink = insert(root.leftLink, value);
            } else { // Otherwise insert to root node right
                root.rightLink = insert(root.rightLink, value);
            }
            return root;
        }

        // Delete a node
        public Node delete(Node root, Node previousRoot, boolean left, int value) {
            if(root == null){
                System.out.println("Value not found");
            } else if(root.value == value){
                if(left){
                    previousRoot.leftLink = null;
                } else {
                    previousRoot.rightLink = null;
                }
            } else if(value < root.value) {
                root.leftLink = delete(root.leftLink,  root, true, value);
            } else {
                root.rightLink = delete(root.rightLink, root, false, value);
            }
            return root;
        }

        public Node find(Node root, int value) {
            if(root == null){
                System.out.println("Value not found");
            } else if(root.value == value){
                System.out.println("Found value " + root.value);
            } else if(value < root.value) {
                root.leftLink = delete(root.leftLink,  root, true, value);
            } else {
                root.rightLink = delete(root.rightLink, root, false, value);
            }
            return root;
        }

        public void traverse(Node root){
            if(root == null){
                return;
            }

            traverse(root.leftLink);
            traverse(root.rightLink);
        }
    }
}
