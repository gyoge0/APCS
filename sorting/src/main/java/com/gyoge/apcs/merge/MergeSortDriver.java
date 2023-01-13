// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.merge;

import javax.swing.JFrame;

public class MergeSortDriver {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting");
        frame.setSize(1000, 1000);
        frame.setLocation(430, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MergeSortPanel());
        frame.setVisible(true);
    }
}
