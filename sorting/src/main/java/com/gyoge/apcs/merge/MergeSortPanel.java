// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.merge;

import com.gyoge.apcs.SortPanel;

public class MergeSortPanel extends SortPanel {

    public MergeSortPanel() {

        // initialize an array with random values
        int[] myArray = generateArray();

        // create a sorting object
        MergeSort sort = new MergeSort(myArray, this);

        // set up the graphics area
        getPanelGraphics();

        // create thread for sorting
        Thread sortingThread = new Thread(sort);

        sortingThread.start();
    }
}
