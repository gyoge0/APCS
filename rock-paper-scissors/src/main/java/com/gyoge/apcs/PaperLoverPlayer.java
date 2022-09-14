// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class PaperLoverPlayer extends GamePlayer {

    public PaperLoverPlayer(String name) {
        super(name);
    }

    @Override
    public void makeChoice() {
        setChoice(Choice.PAPER);
    }
}
