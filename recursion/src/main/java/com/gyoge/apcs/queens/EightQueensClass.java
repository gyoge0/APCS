// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.queens;

import java.util.Arrays;

public class EightQueensClass {

    final int MAX_ROWS = 8;
    final int MAX_COLS = MAX_ROWS;
    private int[] queens;
    private int numIterations;

    public EightQueensClass(int initRow) {
        this.queens = new int[MAX_ROWS];
        this.numIterations = 0;
        Arrays.fill(queens, -1);
        queens[0] = initRow;
    }

    public void printQueenArray(int row) {
        for (int k = 0; k <= row; k++) {
            System.out.print(this.queens[k] + " ");
        }
        System.out.println();
    }

    /** validateHorizontal: verify there is not a queen in the specified row. */
    public boolean validateHorizontal(int row) {
        for (int i = 0; i < MAX_ROWS; i++) {
            if (i == row) continue;
            if (queens[i] == queens[row]) return false;
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
        for (int otherCol = 0; otherCol < MAX_COLS; otherCol++) {
            if (otherCol == col) continue;
            int otherRow = queens[otherCol];
            if (otherCol - otherRow == row - col) return false;
        }
        return true;
    }

    public boolean tryQueen(int c) {
        numIterations++;
        if (c == MAX_COLS) {
            for (int row = 0; row < MAX_ROWS; row++) {
                if (!validateHorizontal(row)) {
                    return false;
                }
                if (!validateDiagonal(row, queens[row])) {
                    return false;
                }
            }
            return true;
        }

        for (int row = 0; row < MAX_ROWS; row++) {
            queens[c] = row;
            boolean valid = tryQueen(c + 1);
            if (valid) return true;
            else queens[c] = -1;
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
