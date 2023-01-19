// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class InsertionSort {

    public static <T extends Comparable<T>> void printArray(T[] arr) {
        for (T t : arr) {
            System.out.println(t);
        }
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
