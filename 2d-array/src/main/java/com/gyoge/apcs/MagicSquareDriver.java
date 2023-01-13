// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class MagicSquareDriver {

    public static void main(String[] args) {
        int[][] a = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        MagicSquare temp = new MagicSquare(a);
        System.out.println(temp.isMagic()); // true

        int[][] b = {
            {1, 1, 2},
            {3, 2, 3},
            {1, 4, 1}
        };
        temp = new MagicSquare(b);
        System.out.println(temp.isMagic()); // false

        int[][] c = {
            {1, 1, 1},
            {2, 2, 2}
        };
        temp = new MagicSquare(c);
        System.out.println(temp.isMagic()); // false

        int[][] d = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
        };
        temp = new MagicSquare(d);
        System.out.println(temp.isMagic()); // true
    }

    public static class MagicSquare {

        private final int[][] a;

        public MagicSquare(int[][] a) {
            this.a = a;
        }

        public boolean isMagic() {
            int sum = sumMajorDiagonal(a);
            for (int i = 0; i < a.length; i++) {
                if (a[i].length != a.length || sumRow(a, i) != sum || sumCol(a, i) != sum)
                    return false;
            }
            return sumMinorDiagonal(a) == sum;
        }

        public static int sumMajorDiagonal(int[][] a) {
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += a[i][i];
            }
            return sum;
        }

        public static int sumRow(int[][] a, int r) {
            int sum = 0;
            for (int i : a[r]) {
                sum += i;
            }
            return sum;
        }

        public static int sumCol(int[][] a, int c) {
            int sum = 0;
            for (int[] r : a) {
                sum += r[c];
            }
            return sum;
        }

        public static int sumMinorDiagonal(int[][] a) {
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += a[i][a[i].length - 1 - i];
            }
            return sum;
        }
    }
}
