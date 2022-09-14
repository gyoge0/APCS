// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.markov;

import com.gyoge.apcs.GamePlayer.Choice;
import java.util.ArrayDeque;
import java.util.Queue;

public class Matrix {

    public static final int MEMORY =
            10; // Smaller numbers will adapt quicker, but won't recognize larger patterns

    private final Queue<Choice> afterRock = new ArrayDeque<>(MEMORY + 1);
    private final Queue<Choice> afterPaper = new ArrayDeque<>(MEMORY + 1);
    private final Queue<Choice> afterScissors = new ArrayDeque<>(MEMORY + 1);

    public void add(Choice before, Choice made) {
        Queue<Choice> queue =
                switch (before) {
                    case ROCK -> afterRock;
                    case PAPER -> afterPaper;
                    case SCISSORS -> afterScissors;
                };
        queue.add(made);
        if (queue.size() > MEMORY) {
            queue.remove();
        }
    }

    public Choice predict(Choice before) {
        Queue<Choice> queue =
                switch (before) {
                    case ROCK -> afterRock;
                    case PAPER -> afterPaper;
                    case SCISSORS -> afterScissors;
                };

        int rock = 0;
        int paper = 0;
        int scissors = 0;

        for (Choice choice : queue) {
            switch (choice) {
                case ROCK -> rock++;
                case PAPER -> paper++;
                case SCISSORS -> scissors++;
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
