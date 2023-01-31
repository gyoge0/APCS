package com.gyoge.apcs;
public class QueueTester {

    public static void main(String[] args) {

        Queue myQueue = new Queue();
        for (int i = 2; i <= 20; i += 2) {
            myQueue.enqueue(i);
        }

        //test dequeues
        System.out.println("dequeue1 should be 2: " + myQueue.dequeue());
        System.out.println("dequeue2 should be 4: " + myQueue.dequeue());
        System.out.println("dequeue3 should be 6: " + myQueue.dequeue());

        //test enqueue after dequeues
        myQueue.enqueue(30);

        System.out.println("Size should be 8: " + myQueue.size());

        //test empty
        // should print 2,3,6,8,10,12,14,30
        //noinspection SpellCheckingInspection
        System.out.println("dequeueing: ");
        while (!myQueue.isEmpty()) {
            System.out.print(" " + myQueue.dequeue());
        }

        //test resize
        for (int i = 1; i < 100; i += 2) {
            myQueue.enqueue(i);
        }

        // output should be 99 97 95 93 91 89 87 85 83 81 79 77 75 73 71 69 67
        //65 63 61 59 57 55 53 51 49 47 45 43 41 39 37 35 33 31 29 27 25 23 21
        //19 17 15 13 11 9 7 5 3 1

        System.out.println("\nResize: ");
        while (!myQueue.isEmpty()) {
            System.out.print(" " + myQueue.dequeue());
        }

    }
}