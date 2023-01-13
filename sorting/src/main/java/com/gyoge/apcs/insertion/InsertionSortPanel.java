// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.insertion;

import com.gyoge.apcs.SortPanel;

public class InsertionSortPanel extends SortPanel {

    public InsertionSortPanel() {

        // initialize an array with random values
        int[] myArray = generateArray();

        // create a sorting object
        InsertionSort sort = new InsertionSort(myArray, this);

        // set up the graphics area
        getPanelGraphics();

        // create thread for sorting
        Thread sortingThread = new Thread(sort);

        sortingThread.start();
    }
}
