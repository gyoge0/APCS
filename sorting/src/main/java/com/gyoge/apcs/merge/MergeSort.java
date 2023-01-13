// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.merge;

public class MergeSort implements Runnable {

    int[] sortArray;
    MergeSortPanel panel;

    public MergeSort(int[] anArray, MergeSortPanel aPanel) {
        sortArray = anArray;
        panel = aPanel;
    }

    public void merge(int begIdx, int middleIdx, int endIdx) {
        int helperSize = endIdx - begIdx + 1;
        int leftIdx = begIdx;
        int rightIdx = middleIdx + 1;
        int[] helperArr = new int[helperSize];
        int helperArrayIdx = 0;

        while (leftIdx <= middleIdx && rightIdx <= endIdx) {
            if (sortArray[leftIdx] < sortArray[rightIdx]) {
                helperArr[helperArrayIdx] = sortArray[leftIdx];
                leftIdx++;
            } else {
                helperArr[helperArrayIdx] = sortArray[rightIdx];
                rightIdx++;
            }
            helperArrayIdx++;
        }

        int remainingIdx = leftIdx <= middleIdx ? leftIdx : rightIdx;
        while (helperArrayIdx < helperSize) {
            helperArr[helperArrayIdx] = sortArray[remainingIdx];
            remainingIdx++;
            helperArrayIdx++;
        }

        helperArrayIdx = 0;
        for (int index = begIdx; index <= endIdx; index++) {
            sortArray[index] = helperArr[helperArrayIdx];
            helperArrayIdx++;
            panel.updateArray(sortArray);
        }
    }

    public void mergeSort(int begIdx, int endIdx) {
        if (endIdx <= begIdx) {
            return;
        }
        int middleIdx = (begIdx + endIdx) / 2;

        mergeSort(begIdx, middleIdx);
        mergeSort(middleIdx + 1, endIdx);
        merge(begIdx, middleIdx, endIdx);
    }

    public void run() {
        mergeSort(0, sortArray.length - 1);
    }
}
