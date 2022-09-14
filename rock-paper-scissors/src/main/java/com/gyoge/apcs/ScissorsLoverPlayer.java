// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class ScissorsLoverPlayer extends GamePlayer {

    public ScissorsLoverPlayer(String name) {
        super(name);
    }

    @Override
    public void makeChoice() {
        setChoice(Choice.SCISSORS);
    }
}
