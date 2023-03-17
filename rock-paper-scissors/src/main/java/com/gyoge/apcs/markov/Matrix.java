// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.markov;

import com.gyoge.apcs.Choice;
import java.util.ArrayDeque;
import java.util.Queue;

public class Matrix {

    public static final int MEMORY =
            10; // Smaller numbers will adapt quicker, but won't recognize larger patterns

    private final Queue<Choice> afterRock = new ArrayDeque<>(MEMORY + 1);
    private final Queue<Choice> afterPaper = new ArrayDeque<>(MEMORY + 1);
    private final Queue<Choice> afterScissors = new ArrayDeque<>(MEMORY + 1);

    public void add(Choice before, Choice made) {
        Queue<Choice> queue;
        switch (before) {
            case ROCK:
                queue = afterRock;
                break;
            case PAPER:
                queue = afterPaper;
                break;
            case SCISSORS:
                queue = afterScissors;
                break;
            default:
                throw new IllegalArgumentException();
        }
        queue.add(made);
        if (queue.size() > MEMORY) {
            queue.remove();
        }
    }

    public Choice predict(Choice before) {
        Queue<Choice> queue;
        switch (before) {
            case ROCK:
                queue = afterRock;
                break;
            case PAPER:
                queue = afterPaper;
                break;
            case SCISSORS:
                queue = afterScissors;
                break;
            default:
                throw new IllegalArgumentException();
        }

        int rock = 0;
        int paper = 0;
        int scissors = 0;

        for (Choice choice : queue) {
            switch (choice) {
                case ROCK:
                    rock++;
                    break;
                case PAPER:
                    paper++;
                    break;
                case SCISSORS:
                    scissors++;
                    break;
            }
        }

        if (rock > paper && rock > scissors) {
            return Choice.PAPER;
        } else if (paper > scissors) {
            return Choice.SCISSORS;
        } else {
            return Choice.ROCK;
        }
    }
}
