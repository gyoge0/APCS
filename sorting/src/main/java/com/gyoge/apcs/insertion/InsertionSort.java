// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.insertion;

public class InsertionSort implements Runnable {

    int[] sortArray;
    InsertionSortPanel panel;

    public InsertionSort(int[] anArray, InsertionSortPanel aPanel) {
        sortArray = anArray;
        panel = aPanel;
    }

    public void run() {
        for (int i = 1; i < sortArray.length; i++) {
            int j = i;
            while (j > 0 && sortArray[j] < sortArray[j - 1]) {
                swap(sortArray, j, j - 1);
                j--;
                panel.updateArray(sortArray);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
