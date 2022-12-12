package com.gyoge.apcs;

import finch.Finch;

public class FinchFractals {

    //TODO: create a field for your finch; instantiate it here
    public static final Finch finch = new Finch();

    /* This method calls itself recursively to draw a Koch fractal. */
    public static void drawFractal(int order, double distance) {
        //TODO: create the drawFractal method
        if (order == 0) {
            finch.setMove("F", distance, 100);
        } else {
            drawFractal(order - 1, distance / 3);
            finch.setTurn("L", 60, 100);
            drawFractal(order - 1, distance / 3);
            finch.setTurn("R", 120, 100);
            drawFractal(order - 1, distance / 3);
            finch.setTurn("L", 60, 100);
            drawFractal(order - 1, distance / 3);
        }
    }

    public static void main(String[] args) {
        //call the drawFractal method for an order and distance
        drawFractal(4, 15);
        finch.setTurn("R", 120, 100);
        //TODO: Draw two more fractals to create a snowflake
        drawFractal(4, 15);
        finch.setTurn("R", 120, 100);
        drawFractal(4, 15);
        finch.setTurn("R", 120, 100);

        //TODO: Close connection to your finch
        finch.disconnect();
    }
}