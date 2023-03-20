// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ProcessImage {

    public static final int BLACK = 0;
    public static final int WHITE = 255;
    public static int[][] pixelValues;

    // Code to test
    public static void main(String[] args) {
        pixelValues =
            new int[][]{
                {221, 184, 178, 84, 135},
                {84, 255, 255, 130, 84},
                {78, 255, 0, 0, 78},
                {84, 130, 255, 130, 84}
            };
        System.out.println("Count: " + countWhitePixels());
        processImage();
        System.out.println(Arrays.deepToString(pixelValues));
    }

    public static int countWhitePixels() {
        int count = 0;
        for (int[] r : pixelValues) {
            for (int i : r) {
                if (i == WHITE) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void processImage() {
        for (int r = 0; r < pixelValues.length - 2; r++) {
            for (int c = 0; c < pixelValues[r].length - 2; c++) {
                pixelValues[r][c] = Math.max(BLACK, pixelValues[r][c] - pixelValues[r + 2][c + 2]);
            }
        }
    }

    // method for testing
    public static boolean equalMatrices(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return false;
        }
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                if (a[r][c] != b[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
