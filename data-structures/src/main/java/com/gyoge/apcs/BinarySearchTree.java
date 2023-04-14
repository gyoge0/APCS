package com.gyoge.apcs;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private Node<K, V> root;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public BinarySearchTree() {
        root = null;
    }

    public void add(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        size++;
        if (root == null) {
            root = node;
        } else {
            addWithNode(root, node);
        }
    }

    private void addWithNode(@NotNull Node<K, V> addTo, @NotNull Node<K, V> node) {
        if (addTo.compareTo(node) < 0) {
            // add to right
            if (addTo.right == null) {
                addTo.right = node;
            } else {
                addWithNode(addTo.right, node);
            }
        } else {
            // add to left
            if (addTo.left == null) {
                addTo.left = node;
            } else {
                addWithNode(addTo.left, node);
            }
        }
    }

    @Nullable
    public V get(K key) {
        if (root == null) {
            return null;
        } else {
            return getWithNode(root, key);
        }
    }

    @Nullable
    private V getWithNode(@NotNull Node<K, V> node, K key) {
        if (node.key.equals(key)) {
            return node.value;
        } else if (node.key.compareTo(key) < 0) {
            // check right
            if (node.right == null) {
                return null;
            } else {
                return getWithNode(node.right, key);
            }
        } else {
            // check left
            if (node.left == null) {
                return null;
            } else {
                return getWithNode(node.left, key);
            }
        }
    }

    public int getDepth() {
        if (root == null) {
            return 0;
        } else {
            return root.getDepth();
        }
    }

    public void breathFirstSearch() {
        if (root == null) {
            return;
        }

        Queue<Node<K, V>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<K, V> node = queue.remove();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public void depthFirstSearch() {
        if (root == null) {
            return;
        }

        Deque<Node<K, V>> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<K, V> node = stack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static class Node<K extends Comparable<K>, V> implements Comparable<Node<K, V>> {
        @NotNull
        private final K key;
        @Nullable
        private final V value;
        @Nullable
        private Node<K, V> left;
        @Nullable
        private Node<K, V> right;

        public Node(@NotNull K key, @Nullable V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(@NotNull Node<K, V> o) {
            return key.compareTo(o.key);
        }

        private int getDepth() {
            int leftDepth = left == null ? 0 : left.getDepth();
            int rightDepth = right == null ? 0 : right.getDepth();
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void testGet(BinarySearchTree<Integer, Integer> bst, Integer key) {
        Integer rVal = bst.get(key);
        System.out.printf("get(%d)=%s\n", key, rVal);
    }

    public static void main(String[] args) {
        //suggestion, draw out the tree on paper to verify depth, BFS, and DFS
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
        bst.add(5, 500);
        bst.add(3, 300);
        bst.add(9, 900);
        bst.add(12, 1200);
        bst.add(14, 1400);
        bst.add(11, 1100);
        bst.add(10, 1000);
        System.out.println("size: " + bst.getSize());

        testGet(bst, 5);
        testGet(bst, 3);
        testGet(bst, 9);
        testGet(bst, 12);
        testGet(bst, 14);
        testGet(bst, 11);
        testGet(bst, 10);
        testGet(bst, 1);
        testGet(bst, 2);
        testGet(bst, 8);
        testGet(bst, 13);
        testGet(bst, 99);

        System.out.println("depth: " + bst.getDepth());
        bst.breathFirstSearch();
        System.out.println();

        bst.depthFirstSearch();
        System.out.println();

    }

}
