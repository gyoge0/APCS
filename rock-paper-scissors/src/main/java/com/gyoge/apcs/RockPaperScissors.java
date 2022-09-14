// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import com.gyoge.apcs.GamePlayer.Choice;
import java.util.Scanner;

public class RockPaperScissors {

    /** Default score to win */
    public static final int DEFAULT_WINNING_SCORE = 2;

    public static void main(String[] args) {
        GamePlayer player1;
        GamePlayer player2;

        player1 = choosePlayerType();
        player2 = choosePlayerType();

        int winningScore = getWinningScore();

        while (Math.max(player1.getWins(), player2.getWins()) < winningScore) {
            player1.makeChoice();
            player2.makeChoice();

            showChoices(player1, player2);

            GamePlayer winner = compareChoices(player1, player2);
            printWinner(winner);
            printRecord(player1);
            printRecord(player2);
        }

        printEndGameMessage();
    }

    /**
     * Asks for the number of wins to win the game. If the value is less than or equal to zero,
     * then, by default, the winning score will be {@value #DEFAULT_WINNING_SCORE}
     *
     * @return the number of wins to win the game
     */
    static int getWinningScore() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("How many wins to win the game? ");
            int winningScore = scanner.nextInt();

            if (winningScore <= 0) {
                return DEFAULT_WINNING_SCORE;
            }
            return winningScore;
        }
    }

    /**
     * Prints the record of the given <code>Player</code>
     *
     * @param player the player of the game
     */
    private static void printRecord(GamePlayer player) {
        System.out.printf("%s has %d wins%n", player.getName(), player.getWins());
    }

    /**
     * Prints the winner of the round
     *
     * @param winner the <code>GamePlayer</code> who is the winner of the round
     */
    private static void printWinner(GamePlayer winner) {
        if (winner == null) {
            System.out.println("Tie\n");
        } else {
            System.out.printf("%s wins!!\n%n", winner.getName());
        }
    }

    /**
     * Compares and returns who wins the round.
     *
     * @param player1 a <code>GamePlayer</code>
     * @param player2 a <code>GamePlayer</code>
     * @return returns the <code>GamePlayer</code> who wins the game, <code>null</code> if there is
     *     a tie
     */
    public static GamePlayer compareChoices(GamePlayer player1, GamePlayer player2) {
        Choice c1 = player1.getChoice();
        Choice c2 = player2.getChoice();

        if (c1 == c2) return null;
        else if (c2.losesTo() == c1) return player1;
        else if (c1.losesTo() == c2) return player2;
        else throw new IllegalStateException("Invalid choices");
    }

    /**
     * Prints the choices for both players
     *
     * @param player1 a player
     * @param player2 a player
     */
    public static void showChoices(GamePlayer player1, GamePlayer player2) {
        System.out.printf(
                "%n%s: %s   vs.  %s: %s%n%n",
                player1.getName(),
                player1.getChoiceName(),
                player2.getName(),
                player2.getChoiceName());
    }

    /**
     * Prompts the choices and returns the types of players to play the game
     *
     * @return the type of player to play the game
     */
    static GamePlayer choosePlayerType() {

        System.out.println();
        System.out.println(
                """
            Choose a type of player:
            \t1. Human
            \t2. Computer
            \t3. Rock Lover
            Make your choice:\s""");

        Scanner input = new Scanner(System.in);
        int type = Integer.parseInt(input.nextLine());

        return switch (type) {
            case 1 -> {
                System.out.print("What is your name: ");
                String name = input.nextLine();
                yield new HumanPlayer(name);
            }
            case 2 -> new ComputerPlayer("Computer");
            case 3 -> new RockLoverPlayer("Rock Lover");
            default -> throw new IllegalArgumentException("Invalid player type");
        };
    }

    /** Prints a message when the game is over. */
    private static void printEndGameMessage() {
        System.out.println("Game over!");
    }
}