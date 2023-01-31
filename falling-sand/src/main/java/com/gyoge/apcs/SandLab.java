package com.gyoge.apcs;

import java.awt.Color;
import java.util.Random;

public class SandLab {

    //add constants for particle types here
    public static final int EMPTY = 0;
    public static final int METAL = 1;
    public static final int SAND = 2;
    public static final int WATER = 3;
    //do not add any more fields
    private final int[][] grid;
    private final SandDisplay display;
    private final Random random = new Random();
    public SandLab(int numRows, int numCols) {
        String[] names;
        names = new String[4];
        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
        names[SAND] = "Sand";
        names[WATER] = "Water";
        display = new SandDisplay("Falling Sand", numRows, numCols, names);
        grid = new int[numRows][numCols];
    }

    public static void main(String[] args) {
        SandLab lab = new SandLab(120, 80);
        lab.run();
    }

    // do not modify
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        while (true) {
            for (int i = 0; i < display.getSpeed(); i++) {
                step();
            }
            updateDisplay();
            display.repaint();
            display.pause(1);  // wait for redrawing and for mouse
            int[] mouseLoc = display.getMouseLocation();
            // test if mouse clicked
            if (mouseLoc != null) {
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
            }
        }
    }

    //called repeatedly.
    //causes one random particle to maybe do something.
    public void step() {
        int x = random.nextInt(grid.length);
        int y = random.nextInt(grid[x].length);

        if (grid[x][y] == SAND && x + 1 < grid.length) {

            if (grid[x + 1][y] == EMPTY) {
                grid[x][y] = EMPTY;
            } else if (grid[x + 1][y] == WATER) {
                grid[x][y] = WATER;
            }

            grid[x + 1][y] = SAND;
        } else if (grid[x][y] == WATER) {
            int direction = random.nextInt(3);
            int newX = x;
            int newY = y;
            switch (direction) {
                case 1 -> newX++;
                case 2 -> newY++;
                case 0 -> newY--;
            }

            if (newX < grid.length && newY < grid[newX].length && newY >= 0
                && grid[newX][newY] == EMPTY) {
                grid[x][y] = EMPTY;
                grid[newX][newY] = WATER;
            }
        }
    }

    //copies each element of grid into the display
    public void updateDisplay() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                Color color = switch (grid[row][col]) {
                    case METAL -> Color.GRAY;
                    case SAND -> Color.YELLOW;
                    case WATER -> Color.BLUE;
                    default -> Color.BLACK;
                };
                display.setColor(row, col, color);
            }
        }
    }

    //called when the user clicks on a location using the given tool
    private void locationClicked(int row, int col, int tool) {
        grid[row][col] = tool;
    }
}