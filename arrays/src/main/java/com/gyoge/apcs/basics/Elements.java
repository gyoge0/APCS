// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.basics;

@SuppressWarnings("unused")
public class Elements {

    /**
     * reverse the order of the values in the array between i (inclusive) and j (exclusive)
     *
     * @param ns an array of ints
     * @param i  an int that is a valid index for ns
     * @param j  an int that satisfies i <= j <= ns.length
     *           <p>post-condition: values in the array between i (inclusive) and j (exclusive) now
     *           appear
     *           in the reverse order, and ns is unchanged otherwise
     */
    public static void reverse(int[] ns, int i, int j) {
        while (j > i) {
            swap(ns, i, j);
            i++;
            j--;
        }
    }

    /**
     * swap two array values
     *
     * @param ns an array of ints with positive length
     * @param i  an int that is a valid index for ns
     * @param j  an int that is a valid index for ns
     *           <p>post-condition: values at indices i and j are swapped and ns is otherwise
     *           unchanged.
     */
    public static void swap(int[] ns, int i, int j) {
        int tmp = ns[i];
        ns[i] = ns[j];
        ns[j] = tmp;
    }

    /**
     * shift the values in the array k values to the right, wrapping around if they go out the end
     *
     * @param ns an array of ints with positive length
     * @param k  an int that is a valid index for ns
     *           <p>post-condition: values in the array are shifted as described above
     */
    @SuppressWarnings("ManualArrayCopy")
    public static void rightShift(int[] ns, int k) {
        int[] nns = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nns[(i + k) % ns.length] = ns[i];
        }
        for (int i = 0; i < ns.length; i++) {
            ns[i] = nns[i];
        }
    }
}
