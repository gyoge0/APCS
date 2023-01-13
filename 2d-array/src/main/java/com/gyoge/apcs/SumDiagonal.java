// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class SumDiagonal {

    public static void main(String[] args) {
        int[][] a = {
            {-5, -2, -3, 7},
            {1, -5, -2, 2},
            {1, -2, 3, -4},
            {1, -2, 3, -4}
        };
        System.out.println(sumDiagonalRL(a)); // should print 4
    }

    public static int sumDiagonalRL(int[][] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i][a[i].length - 1 - i];
        }
        return sum;
    }
}
