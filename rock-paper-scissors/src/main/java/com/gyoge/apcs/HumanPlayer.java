// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.Scanner;

public class HumanPlayer extends GamePlayer {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void makeChoice() {
        Scanner scanner = new Scanner(System.in);
        Choice choice = null;
        while (choice == null) {
            System.out.printf(
                    """
                    Enter your choice %s:
                    \t1. Rock
                    \t2. Paper
                    \t3. Scissors
                    Make your choice: """,
                    this.getName());

            choice =
                    switch (scanner.nextLine().toLowerCase()) {
                        case "1", "r", "rock" -> Choice.ROCK;
                        case "2", "p", "paper" -> Choice.PAPER;
                        case "3", "s", "scissors" -> Choice.SCISSORS;
                        default -> {
                            System.out.println(
                                    "Sorry, I don't understand what that means. Try again.");
                            yield null;
                        }
                    };
        }
        setChoice(choice);
    }
}
