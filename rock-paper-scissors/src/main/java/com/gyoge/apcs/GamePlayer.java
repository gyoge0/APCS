// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

@SuppressWarnings("unused")
public abstract class GamePlayer {

    private final String name;
    private Choice choice;
    private int wins;
    private int draws;
    private int losses;

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GamePlayer{"
                + "name='"
                + name
                + '\''
                + ", choice="
                + choice
                + ", wins="
                + wins
                + ", draws="
                + draws
                + ", losses="
                + losses
                + '}';
    }

    public String getName() {
        return name;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public int getWins() {
        return wins;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    /**
     * @return the string name of the player's choice
     */
    public String getChoiceName() {
        return this.choice.name;
    }

    /** Make a move */
    public abstract void makeChoice();

    /** Increment {@link GamePlayer#wins} */
    public void win() {
        wins++;
    }

    /** Increment {@link GamePlayer#draws} */
    public void draw() {
        draws++;
    }

    /** Increment {@link GamePlayer#losses} */
    public void lose() {
        losses++;
    }

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
}
