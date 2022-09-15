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
        return switch (this) {
            case ROCK -> PAPER;
            case PAPER -> SCISSORS;
            case SCISSORS -> ROCK;
        };
    }
}
