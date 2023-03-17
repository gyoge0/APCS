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
                "Enter your choice %s:\n" +
                "\t1. Rock\n" +
                "\t2. Paper\n" +
                "\t3. Scissors\n" +
                "Make your choice:",
                    this.getName());

            switch (scanner.nextLine().toLowerCase()) {
                case "1":
                case "r":
                case "rock":
                    choice = Choice.ROCK;
                    break;
                case "2":
                case "p":
                case "paper":
                    choice = Choice.PAPER;
                    break;
                case "3":
                case "s":
                case "scissors":
                    choice = Choice.SCISSORS;
                    break;
                default:
                    System.out.println(
                        "Sorry, I don't understand what that means. Try again.");
                    choice = null;
                    break;
            }
        }
        setChoice(choice);
    }
}
