// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class SumRow {

    public static void main(String[] args) {
        int[][] a = {
            {1, 1, 2}, // sum = 4
            {3, 1, 2}, // sum = 6
            {3, 5, 3}, // sum = 11
            {0, 1, 2} // sum = 3
        };

        int[] sums = rowSums(a);
        for (int sum : sums) {
            System.out.println(sum);
        }
        // this should print 4 6 11 3
    }

    public static int[] rowSums(int[][] a) {
        int[] sums = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int x : a[i]) {
                sums[i] += x;
            }
        }
        return sums;
    }
}
