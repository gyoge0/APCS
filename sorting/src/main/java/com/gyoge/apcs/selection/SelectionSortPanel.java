// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.selection;

import com.gyoge.apcs.SortPanel;

public class SelectionSortPanel extends SortPanel {

    public SelectionSortPanel() {

        // initialize an array with random values
        int[] myArray = generateArray();

        // create a sorting object
        SelectionSort sort = new SelectionSort(myArray, this);

        // set up the graphics area
        getPanelGraphics();

        // create thread for sorting
        Thread sortingThread = new Thread(sort);

        sortingThread.start();
    }
}
