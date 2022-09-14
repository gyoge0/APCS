// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs

import com.gyoge.apcs.RockPaperScissors.DEFAULT_WINNING_SCORE
import com.gyoge.apcs.RockPaperScissors.compareChoices
import com.gyoge.apcs.RockPaperScissors.getWinningScore
import com.gyoge.apcs.RockPaperScissors.showChoices
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RockPaperScissorsTest : IOTest() {
    @Nested
    inner class CompareChoicesTest {
        @Test fun `rock vs rock`() {
            val p1 = ComputerPlayer("p1").apply { choice = GamePlayer.Choice.ROCK }
            val p2 = ComputerPlayer("p2").apply { choice = GamePlayer.Choice.ROCK }
            assertEquals(
                null,
                compareChoices(p1, p2)
            )
        }

        @Test fun `rock vs paper`() {
            val p1 = ComputerPlayer("p1").apply { choice = GamePlayer.Choice.ROCK }
            val p2 = ComputerPlayer("p2").apply { choice = GamePlayer.Choice.PAPER }
            assertEquals(
                p2,
                compareChoices(p1, p2)
            )
        }

        @Test fun `rock vs scissors`() {
            val p1 = ComputerPlayer("p1").apply { choice = GamePlayer.Choice.ROCK }
            val p2 = ComputerPlayer("p2").apply { choice = GamePlayer.Choice.SCISSORS }
            assertEquals(
                p1,
                compareChoices(p1, p2)
            )
        }

        @Test fun `paper vs paper`() {
            val p1 = ComputerPlayer("p1").apply { choice = GamePlayer.Choice.PAPER }
            val p2 = ComputerPlayer("p2").apply { choice = GamePlayer.Choice.PAPER }
            assertEquals(
                null,
                compareChoices(p1, p2)
            )
        }

        @Test fun `paper vs rock`() {
            val p1 = ComputerPlayer("p1").apply { choice = GamePlayer.Choice.PAPER }
            val p2 = ComputerPlayer("p2").apply { choice = GamePlayer.Choice.ROCK }
            assertEquals(
                p1,
                compareChoices(p1, p2)
            )
        }

        @Test fun `paper vs scissors`() {
            val p1 = ComputerPlayer("p1").apply { choice = GamePlayer.Choice.PAPER }
            val p2 = ComputerPlayer("p2").apply { choice = GamePlayer.Choice.SCISSORS }
            assertEquals(
                p2,
                compareChoices(p1, p2)
            )
        }

        @Test fun `scissors vs scissors`() {
            val p1 = ComputerPlayer("p1").apply { choice = GamePlayer.Choice.SCISSORS }
            val p2 = ComputerPlayer("p2").apply { choice = GamePlayer.Choice.SCISSORS }
            assertEquals(
                null,
                compareChoices(p1, p2)
            )
        }

        @Test fun `scissors vs rock`() {
            val p1 = ComputerPlayer("p1").apply { choice = GamePlayer.Choice.SCISSORS }
            val p2 = ComputerPlayer("p2").apply { choice = GamePlayer.Choice.ROCK }
            assertEquals(
                p2,
                compareChoices(p1, p2)
            )
        }

        @Test fun `scissors vs paper`() {
            val p1 = ComputerPlayer("p1").apply { choice = GamePlayer.Choice.SCISSORS }
            val p2 = ComputerPlayer("p2").apply { choice = GamePlayer.Choice.PAPER }
            assertEquals(
                p1,
                compareChoices(p1, p2)
            )
        }
    }

    @Test fun `show rock vs scissors`() {
        showChoices(
            ComputerPlayer("Player 1").apply { choice = GamePlayer.Choice.ROCK },
            ComputerPlayer("Player 2").apply { choice = GamePlayer.Choice.SCISSORS }
        )
        assertOutput("Player 1: Rock   vs.  Player 2: Scissors")
    }

    @Nested
    inner class WinningScoreTest : IOTest() {
        @Test fun `get negative winning score`() {
            setMockInput("-1")
            assertEquals(
                DEFAULT_WINNING_SCORE,
                getWinningScore()
            )
        }

        @Test fun `get zero winning score`() {
            setMockInput("0")
            assertEquals(
                DEFAULT_WINNING_SCORE,
                getWinningScore()
            )
        }

        @Test fun `get positive winning score`() {
            setMockInput("1")
            assertEquals(
                1,
                getWinningScore()
            )
        }
    }
}
