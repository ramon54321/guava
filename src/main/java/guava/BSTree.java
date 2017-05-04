package guava;

import java.util.Scanner;

public class BSTree<T extends Comparable<T>> {

    private Node root;

    public BSTree() {
        this.root = null;
    }

    public void insert_to_tree(T item) {
        Node x = root;
        if (root != null) {
            while (true) {
                int comparison = x.data.compareTo(item);
                if (comparison == 1) {
                    if (x.right != null) {
                        x = x.right;
                    } else {
                        x.right = new Node(item, null, null);
                        break;
                    }
                } else if (comparison == -1) {
                    if (x.left != null) {
                        x = x.left;
                    } else {
                        x.left = new Node(item, null, null);
                        break;
                    }
                } else {
                    break;
                }
            }
        } else {
            root = new Node(item, null, null);
        }
    }

    public void searchTree(T item) {
        Node x = root;
        if (root != null) {
            while (true) {
                int comparison = x.data.compareTo(item);
                if (comparison == 0) {
                    System.out.println("Item found");
                    break;
                } else if (comparison == 1) {
                    if (x.right != null) {
                        x = x.right;
                    } else {
                        System.out.println("Cannot find item");
                        break;
                    }
                } else if (comparison == -1) {
                    if (x.left != null) {
                        x = x.left;
                    } else {
                        System.out.println("Cannot find item");
                        break;
                    }
                }
            }
        } else {
            System.out.println("Cannot find item");
        }
    }

    private class Node {

        private T data;
        private Node left;
        private Node right;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}
