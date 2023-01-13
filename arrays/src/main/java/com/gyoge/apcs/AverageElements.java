// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class AverageElements {

    public static void main(String[] args) {
        int[] a = {2, 7, 3, 8, 4};
        System.out.println(avgElements(a)); // should print 4.8
    }

    public static double avgElements(int[] a) {
        double sum = 0.0;
        for (int i : a) {
            sum += i;
        }
        return sum / a.length;
    }
}
