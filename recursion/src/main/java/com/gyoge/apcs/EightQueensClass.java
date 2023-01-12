// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class EightQueensClass {

    final int MAX_ROWS = 8;
    final int MAX_COLS = MAX_ROWS;
    private int[] queens;
    private int numIterations;

    public EightQueensClass(int initRow) {
        this.queens = new int[MAX_ROWS];
        this.numIterations = 0;
        for (int k = 0; k < queens.length; k++) {
            queens[k] = -1;
        }
        queens[0] = initRow;
    }

    public void printQueenArray(int row) {
        for (int k = 0; k <= row; k++) {
            System.out.print(this.queens[k] + " ");
        }
        System.out.println();
    }

    /*
     * validateHorizontal: verify there is not a queen in the specified row.
     */
    public boolean validateHorizontal(int row) {
        for (int i = 0; i < MAX_COLS; i++) {
            if (queens[i] == row) {
                return false;
            }
        }
        return true;
    }

    /*
     * validateDiagonal: verify there is not a queen in the diagonal direction (45 degrees)
     *        - you only need to look backwards from the specified column
     *        - look in 2 directions:
     *							negative slope: row-1, col-1
     *							positive slope: row+1, col-1
     *        - return false if there is a conflict with another queen.
     *			 - return true if there is no conflict.
     */

    public boolean validateDiagonal(int row, int col) {
        int oc;
        int or;

        oc = col - 1;
        or = row - 1;
        while (oc >= 0 && or >= 0) {
            if (queens[oc] == or) {
                return false;
            }
            oc--;
            or--;
        }

        oc = col + 1;
        or = row + 1;
        while (oc < MAX_COLS && or < MAX_ROWS) {
            if (queens[oc] == or) {
                return false;
            }
            oc++;
            or++;
        }

        oc = col - 1;
        or = row + 1;
        while (oc >= 0 && or < MAX_ROWS) {
            if (queens[oc] == or) {
                return false;
            }
            oc--;
            or++;
        }

        oc = col + 1;
        or = row - 1;
        while (oc < MAX_COLS && or >= 0) {
            if (queens[oc] == or) {
                return false;
            }
            oc++;
            or--;
        }
        return true;
    }

    public boolean tryQueen(int c) {
        numIterations++;
        if (c >= 8) {
            return true;
        }
        // WRITE CODE HERE
        for (int i = 0; i < MAX_ROWS; i++) {
            if (validateDiagonal(i, c) && validateHorizontal(i)) {
                queens[c] = i;
                if (tryQueen(c + 1)) {
                    return true;
                }
                queens[c] = -1;
            }
        }
        return false;
    }

    public int[] getQueenArray() {
        return this.queens;
    }

    public void setQueenArray(int[] inArr) {
        this.queens = inArr;
    }

    public int[] runQueen() {
        int row = this.queens[0];
        if (tryQueen(1)) {
            printQueenArray(MAX_ROWS - 1);
            System.out.printf("row: %d, iterations: %d \n", row, numIterations);
        } else System.out.println("failed");
        return this.queens;
    }
}
