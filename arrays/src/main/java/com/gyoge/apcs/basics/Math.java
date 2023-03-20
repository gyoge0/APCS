// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.basics;

@SuppressWarnings("unused")
public class Math {

    /**
     * find and return the smallest value in the array
     *
     * @param ns an array of ints
     * @return an integer equal to the smallest value in ns, or Integer.MAX_VALUE if ns has length 0
     */
    public static int min(int[] ns) {
        int min = ns[0];
        for (int i : ns) {
            min = java.lang.Math.min(i, min);
        }
        return min;
    }

    /**
     * find and return the average of all values in the array
     *
     * @param ns an array of ints with positive length
     * @return a double equal to the average of all values in the array ns, or 0.0 if ns has length
     * 0
     */
    public static double average(int[] ns) {
        return ((double) sum(ns)) / ns.length;
    }

    /**
     * find and return the sum of all values in the array
     *
     * @param ns an array of ints
     * @return an integer equal to a sum of all values in the array ns, or 0 if ns has length 0
     */
    public static int sum(int[] ns) {
        int sum = 0;
        for (int i : ns) {
            sum += i;
        }
        return sum;
    }
}
