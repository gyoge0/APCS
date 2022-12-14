// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class ComputerPlayer extends GamePlayer {

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public void makeChoice() {
        Choice[] values = Choice.values();
        setChoice(values[(int) (Math.random() * values.length)]);
    }
}
