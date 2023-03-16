// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<String> testLL = new LinkedList<>();
        testLL.addFirst("two");
        testLL.addFirst("one");
        testLL.addLast("three");
        testLL.printList();
        testLL.insert("twenty-two", 1);
        testLL.printList();
        testLL.remove(2);
        testLL.printList();
        testLL.addFirst("six");
        testLL.addLast("seven");
        System.out.println(testLL.get(2));
        testLL.printList();
        System.out.println(testLL.contains("six"));
        System.out.println(testLL.contains("fifty"));
        System.out.println(testLL.indexOf("six"));
        System.out.println(testLL.indexOf("seven"));
    }
}
