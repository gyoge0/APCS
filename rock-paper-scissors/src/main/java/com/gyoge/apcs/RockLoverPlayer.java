// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

@SuppressWarnings("unused")
public class RockLoverPlayer extends GamePlayer {

    /**
     * Constructs a new {@link RockLoverPlayer}
     *
     * @param playerName the name of the player
     */
    public RockLoverPlayer(String playerName) {
        super(playerName);
    }

    /** The player will always choose {@link Choice#ROCK} */
    @Override
    public void makeChoice() {
        setChoice(Choice.ROCK);
    }
}
