// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.markov;

import com.gyoge.apcs.Choice;
import com.gyoge.apcs.GamePlayer;

public class MarkovPlayer extends GamePlayer {

    public MarkovPlayer(String name) {
        super(name);
    }

    private final Matrix matrix = new Matrix();
    private Choice lastOpponentChoice = Choice.ROCK;
    private Choice lastChoice;

    @Override
    public void draw() {
        super.draw();
        Choice opponentCurrentChoice = lastChoice;
        matrix.add(lastOpponentChoice, opponentCurrentChoice);
        lastOpponentChoice = opponentCurrentChoice;
    }

    @Override
    public void lose() {
        super.lose();
        Choice opponentCurrentChoice = lastChoice.losesTo();
        matrix.add(lastOpponentChoice, opponentCurrentChoice);
        lastOpponentChoice = opponentCurrentChoice;
    }

    @Override
    public void win() {
        super.win();
        Choice opponentCurrentChoice;
        switch (lastChoice) {
            case ROCK:
                opponentCurrentChoice = Choice.SCISSORS;
                break;
            case PAPER:
                opponentCurrentChoice = Choice.ROCK;
                break;
            case SCISSORS:
                opponentCurrentChoice = Choice.PAPER;
                break;
            default:
                throw new IllegalArgumentException();
        }
        matrix.add(lastOpponentChoice, opponentCurrentChoice);
        lastOpponentChoice = opponentCurrentChoice;
    }

    @Override
    public void makeChoice() {
        lastChoice = matrix.predict(lastOpponentChoice);
        setChoice(lastChoice);
    }
}
