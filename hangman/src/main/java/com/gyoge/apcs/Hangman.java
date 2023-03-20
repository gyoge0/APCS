// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Hangman extends JPanel {

    private final int TOP_PERCENT = 10;
    private final int HEAD_PERCENT = 15;
    private final int TORSO_PERCENT = 35;

    @SuppressWarnings("unused")
    private final int LEGS_PERCENT = 20;

    private int incorrectGuesses = 0;
    private String answerString;
    private String currString = "";

    public Hangman(String str) {
        reset(str);
    }

    /**
     * I forgot about spaces so this is just a helper method that adds them
     */
    private void addSpaces() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < currString.length() - 1; i++) {
            sb.append(currString.charAt(i));
            sb.append(" ");
        }

        // no trailing space
        // no empty space words in the list
        sb.append(currString.charAt(currString.length() - 1));
        currString = sb.toString();
    }

    /**
     * Removes the spaces so the logic works
     */
    private void removeSpaces() {
        currString = currString.replace(" ", "");
    }

    public String getString() {
        // I'd call add spaces here but this way currString always follows the rules
        return currString;
    }

    @SuppressWarnings("CommentedOutCode")
    public void reset(String str) {
        answerString = str;
        incorrectGuesses = 0;

        //        currString = answerString
        //            .chars()
        //            .mapToObj(c -> c == ' ' ? " " : "_")
        //            .collect(Collectors.joining());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) == ' ' ? " " : "_");
        }
        currString = sb.toString();

        addSpaces();
    }

    @SuppressWarnings("CommentedOutCode")
    public boolean tryCharacter(char ch) {
        if (!answerString.contains(String.valueOf(ch))) {
            incorrectGuesses++;
            repaint();
            return false;
        }

        removeSpaces();

        //        IntStream
        //            .range(0, answerString.length())
        //            .filter(i -> answerString.charAt(i) == ch)
        //            .forEach(i -> sb.setCharAt(i, ch));

        StringBuilder sb = new StringBuilder(currString);
        for (int i = 0; i < answerString.length(); i++) {
            if (answerString.charAt(i) == ch) {
                sb.setCharAt(i, ch);
            }
        }
        currString = sb.toString();

        addSpaces();

        return true;
    }

    /*
     *  All methods below deal with drawing the Hangman image
     *  You do not need to modify them, but can if you want....
     */

    @SuppressWarnings("all")
    public void drawFace(Graphics g, int midX) {
        int height = getHeight();

        int diameter = (int) (HEAD_PERCENT * height / 100.0);
        int start_y = (int) (TOP_PERCENT * (height / 100.0));
        g.fillOval(midX - diameter / 2, start_y, diameter, diameter);
    }

    @SuppressWarnings("all")
    public void drawTorso(Graphics g, int midX) {
        int height = getHeight();

        int start_y = (int) ((TOP_PERCENT + HEAD_PERCENT) * (height / 100.0));
        int end_y = (int) ((TOP_PERCENT + HEAD_PERCENT + TORSO_PERCENT) * (height / 100.0));
        g.drawLine(midX, start_y, midX, end_y);
    }

    @SuppressWarnings("all")
    public void drawRightArm(Graphics g, int midX) {
        int angle = 315;
        int length = (int) ((TORSO_PERCENT / 2) * (getHeight() / 100.0));
        int start_y =
            (int) ((TOP_PERCENT + HEAD_PERCENT + TORSO_PERCENT / 4) * (getHeight() / 100.0));
        int end_x = (int) (midX + length * Math.cos(angle * Math.PI / 180));
        int end_y = (int) (start_y - length * Math.sin(angle * Math.PI / 180));
        g.drawLine(midX, start_y, end_x, end_y);
    }

    @SuppressWarnings("all")
    public void drawLeftArm(Graphics g, int midX) {
        int angle = 225;
        int length = (int) ((TORSO_PERCENT / 2) * (getHeight() / 100.0));
        int start_y =
            (int) ((TOP_PERCENT + HEAD_PERCENT + TORSO_PERCENT / 4) * (getHeight() / 100.0));
        int end_x = (int) (midX + length * Math.cos(angle * Math.PI / 180));
        int end_y = (int) (start_y - length * Math.sin(angle * Math.PI / 180));
        g.drawLine(midX, start_y, end_x, end_y);
    }

    @SuppressWarnings("all")
    public void drawRightLeg(Graphics g, int midX) {
        int angle = 315;
        int length = (int) ((TORSO_PERCENT / 2) * (getHeight() / 100.0));
        int start_y = (int) ((TOP_PERCENT + HEAD_PERCENT + TORSO_PERCENT) * (getHeight() / 100.0));
        int end_x = (int) (midX + length * Math.cos(angle * Math.PI / 180));
        int end_y = (int) (start_y - length * Math.sin(angle * Math.PI / 180));
        g.drawLine(midX, start_y, end_x, end_y);
    }

    @SuppressWarnings("all")
    public void drawLeftLeg(Graphics g, int midX) {
        int angle = 225;
        int length = (int) ((TORSO_PERCENT / 2) * (getHeight() / 100.0));
        int start_y = (int) ((TOP_PERCENT + HEAD_PERCENT + TORSO_PERCENT) * (getHeight() / 100.0));
        int end_x = (int) (midX + length * Math.cos(angle * Math.PI / 180));
        int end_y = (int) (start_y - length * Math.sin(angle * Math.PI / 180));
        g.drawLine(midX, start_y, end_x, end_y);
    }

    @SuppressWarnings("all")
    public void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        g.setColor(Color.gray);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.red);
        if (incorrectGuesses > 0) drawFace(g, width / 2);

        if (incorrectGuesses > 1) drawTorso(g, width / 2);

        if (incorrectGuesses > 2) drawRightArm(g, width / 2);

        if (incorrectGuesses > 3) drawLeftArm(g, width / 2);

        if (incorrectGuesses > 4) drawRightLeg(g, width / 2);

        if (incorrectGuesses > 5) drawLeftLeg(g, width / 2);
    }
}
