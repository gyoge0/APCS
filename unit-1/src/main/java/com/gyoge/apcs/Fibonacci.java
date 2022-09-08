// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.HashMap;
import java.util.Scanner;

public class Fibonacci {

    private static final HashMap<Integer, Integer> memo = new HashMap<>();

    public static int fib(int n) {
        if (memo.containsKey(n)) return memo.get(n);
        int res;

        if (n == 1) res = 0;
        else if (n == 2) res = 1;
        else res = fib(n - 1) + fib(n - 2);

        memo.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("In: ");
        int numOfFibNumbers = inp.nextInt();
        inp.close();

        // write your code below
        for (int i = 1; i <= numOfFibNumbers; i++) {
            System.out.printf("%d ", fib(i));
        }
    }
}
