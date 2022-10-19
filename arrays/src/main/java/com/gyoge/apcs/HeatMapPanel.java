// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HeatMapPanel extends JPanel implements MouseListener {

    public static final int BLOCK_HEIGHT = 8;
    public static final int BLOCK_WIDTH = 8;
    public static final int MAX_TEMP = 150;
    public static final int MIN_TEMP = -150;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    private static final Color BACKGROUND = new Color(204, 204, 204);
    private final double[][] tempGrid = new double[HEIGHT][WIDTH];

    private int mousedRow = -1;
    private int mousedCol = -1;
    private int mousedTemp;

    public HeatMapPanel() {
        // initialize heat map, LEFT-half cold, RIGHT-half hot
        for (int r = 0; r < tempGrid.length; r++) {
            for (int c = 0; c < tempGrid[r].length; c++) {
                // r, c is top down
                tempGrid[c][r] = c < tempGrid[r].length / 2 ? MIN_TEMP : MAX_TEMP;
            }
        }

        // test your temperature to color conversions, see table in the lab document
        for (int temp = MIN_TEMP; temp < MAX_TEMP; temp += 10) {
            System.out.printf(
                    "%5d: %4d, %4d, %4d\n", temp, getRed(temp), getGreen(temp), getBlue(temp));
        }

        // timer
        Timer t = new Timer(40, new Listener());
        t.start();

        // add MouseListener to this panel
        addMouseListener(this);
    }

    public static int getRed(double temp) {
        if (0 < temp) return 255;
        else if (-74 <= temp) return 255 - (int) (-temp * 255 / 74.0);
        else if (temp < -74) return 0;
        else throw new IllegalArgumentException("Temperature out of range");
    }

    public static int getGreen(double temp) {
        if (temp > 150) return 0;
        else if (temp >= 76) return (int) (255 - ((temp - 76) * 255 / 74));
        else if (temp > -75) return 255;
        else if (temp >= -150) return (int) (255 - ((-temp - 75) * 255 / 75));
        else if (temp < -150) return 0;
        else throw new IllegalArgumentException("Temperature out of range");
    }

    public static int getBlue(double temp) {
        if (1 > temp) return 255;
        else if (75 >= temp) return 255 - (int) ((temp - 1) * 255 / 74);
        else if (temp > 75) return 0;
        else throw new IllegalArgumentException("Temperature out of range");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Heat Map");
        frame.setSize(1400, 1005);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new HeatMapPanel());
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        g.setColor(BACKGROUND);
        g.fillRect(0, 0, getWidth(), getHeight());

        // this basically follows the mouse around while it's held down
        Point mousePosition;
        // null check insures it is in the window
        if (mousedRow != -1 && mousedCol != -1 && (mousePosition = getMousePosition()) != null) {
            mousedRow = mousePosition.x / BLOCK_WIDTH;
            mousedCol = mousePosition.y / BLOCK_HEIGHT;
            // this ensures it is in the grid
            if (mousedRow >= 0
                    && mousedRow < tempGrid.length
                    && mousedCol >= 0
                    && mousedCol < tempGrid[mousedRow].length) {
                tempGrid[mousedRow][mousedCol] = mousedTemp;
            }
        }

        for (int r = 0; r < tempGrid.length; r++) {
            for (int c = 0; c < tempGrid[r].length; c++) {
                if (r == mousedRow && c == mousedCol) {
                    continue;
                }

                double tVal = getAvg(r, c);

                tempGrid[r][c] = tVal;
                g.setColor(new Color(getRed(tVal), getGreen(tVal), getBlue(tVal)));

                // (x,y) is the upper left hand corner of the rectangle
                int x = r * BLOCK_WIDTH;
                int y = c * BLOCK_HEIGHT;
                g.fillRect(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
            }
        }

        drawInfo(g);
    }

    /** Gets the average temp in a box around (r, c) */
    private double getAvg(int r, int c) {
        double sum = 0;
        double count = 0;

        if (r > 0) {
            sum += tempGrid[r - 1][c];
            count++;
        }
        if (r < tempGrid.length - 1) {
            sum += tempGrid[r + 1][c];
            count++;
        }
        if (c > 0) {
            sum += tempGrid[r][c - 1];
            count++;
        }
        if (c < tempGrid[r].length - 1) {
            sum += tempGrid[r][c + 1];
            count++;
        }
        return sum / count;
    }

    /** Displays temp info of both sides */
    private void drawInfo(Graphics g) {
        double leftAvg = tempGrid[tempGrid.length / 2][0];
        double rightAvg = tempGrid[tempGrid.length / 2][tempGrid[0].length - 1];
        String avgLeftTempStr = String.format("%7.2f", leftAvg);
        String avgRightTempStr = String.format("%7.2f", rightAvg);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 40));
        g.drawString("Left Side Temp", 10, 60);
        g.drawString(avgLeftTempStr, 100, 120);
        g.drawString("Right Side Temp", BLOCK_WIDTH * WIDTH - 370, 60);
        g.drawString(avgRightTempStr, BLOCK_WIDTH * WIDTH - 280, 120);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();

        mousedRow = x / BLOCK_WIDTH;
        mousedCol = y / BLOCK_HEIGHT;
        switch (event.getButton()) {
            case MouseEvent.BUTTON1 -> mousedTemp = MAX_TEMP * 10;
            case MouseEvent.BUTTON3 -> mousedTemp = MIN_TEMP * 10;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousedRow = -1;
        mousedCol = -1;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    private class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
}
