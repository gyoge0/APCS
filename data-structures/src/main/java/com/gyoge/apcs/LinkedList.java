// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

// Complete LinkedList class with nested helper node class

@SuppressWarnings({"SameParameterValue", "UnusedReturnValue", "unused"})
public class LinkedList<T> {
    private Node<T> head;
    private int size;

    // class for creating node objects that store integers
    // nested in LinkedList since that is the only class that utilizes it
    private static class Node<T> {
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        private T data; // the data stored at this place in the list
        private Node<T> next; // reference to the nextNodePtr node in the list (the link)

        // constructor initializes the data and defaults reference to the nextNodePtr node to null
        Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // Linked List Constructor
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // appends a node with the value num to the beginning of the list
    public void addFirst(T data) {
        /* 1. Create a new node object with the value num
         * 2. Set the new node's nextNodePtr field to reference the current headNodePtr node
         *   (The previous headNodePtr node is now at position 2)
         * 3. Set the headNodePtr field to point to the new node
         * 4. Increase the size field by 1x
         */
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        this.head = newNode;
        this.size++;
    }

    public String printList() {
        Node<T> temp = head;
        StringBuilder str = new StringBuilder();
        while (temp != null) {
            str.append(temp.data).append(" ");
            temp = temp.next;
        }
        System.out.println(str);
        return str.toString();
    }

    // implement other methods here

    public boolean indexOf(T six) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(six)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Node<T> get(int idx) {
        Node<T> current = head;
        for (int i = 0; i < idx; i++) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException();
            }
            current = current.next;
        }
        return current;
    }

    public Node<T> remove(int idx) {
        Node<T> current = head;
        for (int i = 0; i < idx - 1; i++) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException();
            }
            current = current.next;
        }
        Node<T> remove = current.next;
        current.next = remove.next;
        size--;
        return remove;
    }

    public void insert(T data, int idx) {
        Node<T> current = head;
        for (int i = 0; i < idx; i++) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException();
            }
            current = current.next;
        }
        Node<T> currentNext = current.next;
        Node<T> newNode = new Node<>(data);
        current.next = newNode;
        newNode.next = currentNext;
        size++;
    }

    public void addLast(T data) {
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(data);
        size++;
    }
}
