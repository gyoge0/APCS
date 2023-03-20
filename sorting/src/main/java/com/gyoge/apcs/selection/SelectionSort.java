// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.selection;

import com.gyoge.apcs.SortPanel;

public class SelectionSort implements Runnable {

    int[] sortArray;
    SortPanel panel;

    public SelectionSort(int[] anArray, SortPanel aPanel) {
        sortArray = anArray;
        panel = aPanel;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // This is the sort routine on sortArray
    public void run() {
        for (int i = 0; i < sortArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < sortArray.length; j++) {
                if (sortArray[j] < sortArray[min]) {
                    min = j;
                }
            }

            swap(sortArray, i, min);

            panel.updateArray(sortArray);
        }
    }
}
