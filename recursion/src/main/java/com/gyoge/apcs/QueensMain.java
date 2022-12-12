package com.gyoge.apcs;

public class QueensMain {

    public static void main(String[] args) {
        int initialRow = 4;
        EightQueensClass queenGrid = new EightQueensClass(initialRow);
        int[] solution = queenGrid.runQueen();

    }

}
