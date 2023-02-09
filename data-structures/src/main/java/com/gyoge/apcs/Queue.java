// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    private final List<Integer> arr = new ArrayList<>();

    public void enqueue(int i) {
        arr.add(i);
    }

    public int dequeue() {
        if (arr.isEmpty()) {
            return -1;
        }
        return arr.remove(0);
    }

    public int size() {
        return arr.size();
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isEmpty() {
        return arr.isEmpty();
    }
}
