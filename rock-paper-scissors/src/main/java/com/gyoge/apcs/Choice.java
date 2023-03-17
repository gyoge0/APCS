// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

/** All possible choices on a move */
public enum Choice {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");
    public final String name;

    Choice(String name) {
        this.name = name;
    }

    public Choice losesTo() {
        switch (this) {
            case ROCK:
                return PAPER;
            case PAPER:
                return SCISSORS;
            case SCISSORS:
                return ROCK;
            default:
                throw new IllegalArgumentException();
        }
    }
}
