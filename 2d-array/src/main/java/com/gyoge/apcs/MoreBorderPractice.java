// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class MoreBorderPractice {

    public static void main(String[] args) {
        int[][] a = {
            // col    0 1 2 3
            {1, 1, 1, 1}, // row 0
            {1, 1, 1, 1}, // row 1
            {1, 1, 1, 1} // row 2
        };
        System.out.println(isBorder(a, 0, 0)); // true
        System.out.println(isBorder(a, 1, 1)); // false
        System.out.println(isBorder(a, 2, 1)); // true
        System.out.println(isBorder(a, 1, 2)); // false
    }

    public static boolean isBorder(int[][] array, int row, int col) {
        return row == 0 || row == array.length - 1 || col == 0 || col == array[row].length - 1;
    }
}
