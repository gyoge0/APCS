// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Interface for the sorting object to use when updating the UI
 */
public abstract class SortPanel extends JPanel {

    public static final int SCALE = 100;
    public static final int SCREEN_SIZE = 1000;
    public static final int DELAY_LENGTH = 100;
    protected BufferedImage myImage;

    /**
     * Generate a new array that contains random numbers is being properly shuffled.
     *
     * @return A newly minted array of integers in all kinds of fun random order.
     */
    protected int[] generateArray() {
        // set array to random size from 29 to 49 elements
        int size = (int) (Math.random() * 30 + 20);

        // initialize an array with random values
        int[] newArray = new int[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = (int) (Math.random() * SCALE + 1);
        }

        return shuffleArray(newArray);
    }

    private int[] shuffleArray(int[] anArray) {

        Random rnd = new Random();
        for (int i = anArray.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = anArray[index];
            anArray[index] = anArray[i];
            anArray[i] = a;
        } // for
        return anArray;
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
    }

    /**
     * Implement the drawPanel method, hiding the Swing UI elements from the sorting object
     *
     * @param anArray - The array to update
     */
    public void updateArray(final int[] anArray) {
        try {
            SwingUtilities.invokeAndWait(
                () -> {
                    drawArray(anArray);
                    try {
                        Thread.sleep(DELAY_LENGTH);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Draw the given array onto the panel. This redraws everything instead of painting the
     * difference.
     *
     * @param anArray - the array to draw
     */
    protected void drawArray(int[] anArray) {
        // Paste black background on screen to "clear it"
        Graphics graphics = getPanelGraphics();

        // Draw each rectangle
        for (int i = 0; i < anArray.length; i++) {

            // set rectangle color based on value in an array
            int scaleColor = anArray[i] * 255 / SCALE;
            int red = 255 - scaleColor;
            int blue = 255 - scaleColor / 4;
            Color rectColor = new Color(red, scaleColor, blue);
            graphics.setColor(rectColor);

            // draw rectangle
            graphics.fillRect(
                (SCREEN_SIZE / anArray.length) * i,
                SCREEN_SIZE - (((SCREEN_SIZE - 100) / SCALE) * anArray[i]),
                (SCREEN_SIZE / anArray.length) / 2,
                (((SCREEN_SIZE - 100) / SCALE) * anArray[i])
            );

            // draw number on rectangle
            graphics.drawString(
                anArray[i] + "",
                (SCREEN_SIZE / anArray.length) * i,
                SCREEN_SIZE - (((SCREEN_SIZE - 100) / SCALE) * anArray[i]) - 15
            );
        }

        repaint();
    }

    protected Graphics getPanelGraphics() {
        // set up the buffer
        if (null == myImage) {
            myImage = new BufferedImage(SCREEN_SIZE, SCREEN_SIZE, BufferedImage.TYPE_INT_RGB);
        }
        Graphics graphics = myImage.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, SCREEN_SIZE, SCREEN_SIZE);
        return graphics;
    }
}
