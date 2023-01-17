// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Searches {

    private static int linearCount = 0;
    private static int binaryCount = 0;

    public static int getLinearCount() {
        return linearCount;
    }

    public static int getBinaryCount() {
        return binaryCount;
    }

    // this removes the warning for Comparable
    public static int linear(Comparable[] array, Comparable target) {
        for (int i = 0; i < array.length; i++) {
            linearCount++;
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    // this removes the warning for Comparable
    public static int binary(Comparable[] array, Comparable target) {
        return binaryHelper(array, target, 0, array.length - 1);
    }

    private static int binaryHelper(Comparable[] array, Comparable target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + ((end - start) / 2);
        binaryCount++;
        if (array[mid].equals(target)) {
            return mid;
        }

        binaryCount++;
        if (array[mid].compareTo(target) > 0) {
            return binaryHelper(array, target, start, mid - 1);
        }
        return binaryHelper(array, target, mid + 1, end);
    }
}
