/*
T extends Comparable makes it generic, but it can only acceot comparable data types like int and double.

 */


public class BinarySearchTree<T extends Comparable<T>> {

    private static class Node<T> {
        // a tree can be defined recursively

        private T data; // the value this node holds
        private Node<T> left;  // everything > the root
        private Node<T> right; // everything < the root

        // LEAF constructor
        // LEAF node is a node with no children

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ROOT reference
    private Node<T> root;

    // Constructor for empty tree

    public BinarySearchTree() {
        root = null;
    }

//    public void add(T data){
//        Node<T> current =  root;
//        if(current.data < data){
//            current = current.left;
//        }
//
//    }

    // recursive add
    public boolean add(T data) {
        if (root == null) {
            root = new Node<T>(data);
        }
        return add(data, root);
    }

    // Recursive add helper method which will be passed in the next left or right subtree
    private boolean add(T data, Node<T> tree) {

        // need to find the comparison using compareTo
        int difference = data.compareTo(tree.data);


        if (difference < 0) {
            if (tree.left == null) {
                tree.left = new Node<T>(data);
                return true;
            }
            else {
                return add(data, tree.left);
            }
        } else if (difference > 0) {
            if (tree.right == null) {
                tree.right = new Node<T>(data);
                return true;
            }
            else {
                return add(data, tree.right);
            }
        } else {
            return false;
        }
    }
}

