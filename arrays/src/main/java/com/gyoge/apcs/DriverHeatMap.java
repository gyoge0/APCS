// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import javax.swing.JFrame;

/** Driver Class for draw the Heat Map */
public class DriverHeatMap {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Heat Map");
        frame.setSize(HeatMapPanel.CANVAS_WIDTH, HeatMapPanel.CANVAS_HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new HeatMapPanel());
        frame.setVisible(true);
    }
}
