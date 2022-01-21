package com.company.worldcup;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ScoreboardTest {
    private Scoreboard scoreboard;
    private List<Match> matches;


    @BeforeEach
    void setUp() {
        scoreboard = new Scoreboard();

        matches = new ArrayList<>(Arrays.asList(
                new Match(new Team("Uruguay"), new Team("Italy")),
                new Match(new Team("Mexico"), new Team("Canada")),
                new Match(new Team("Argentina"), new Team("Australia"))
        ));
    }

    @Test
    @DisplayName("Should return sorted summary with finished matches")
    void shouldReturnSortedSummaryWithFinishedMatches() {
        for (Match plannedMatch : matches) {
            scoreboard.startGame(plannedMatch);
            scoreboard.updateScore(3, 4);
            scoreboard.finishGame();
        }

        StringBuilder summary = new StringBuilder();
        matches.stream()
                .sorted()
                .filter(Match::isFinished)
                .forEach(match -> summary.append(match).append("\n"));

        Assertions.assertEquals(summary.toString(),
                scoreboard.getSummary());
    }

    @Test
    @DisplayName("Summary should be empty after initializing")
    void SummaryShouldBeEmptyAfterInitializing() {
        Assertions.assertEquals("", scoreboard.getSummary());
    }

    @Test
    @DisplayName("Should start the game")
    void shouldStartTheGame() {
        Match match = matches.get(0);
        scoreboard.startGame(match);

        Assertions.assertEquals(match.toString(), scoreboard.toString());
    }

    @Test
    @DisplayName("Should update score")
    void shouldUpdateScore() {
        Match match = matches.get(0);
        scoreboard.startGame(match);
        scoreboard.updateScore(1, 2);
        scoreboard.updateScore(4, 4);

        Assertions.assertEquals(5, match.getHomeTeam().getScore());
        Assertions.assertEquals(6, match.getAwayTeam().getScore());
    }

    @Test
    @DisplayName("Should finish game")
    void shouldFinishGame() {
        Match match = matches.get(0);
        scoreboard.startGame(match);
        scoreboard.finishGame();

        // Current match should be empty
        Assertions.assertNotEquals(match.toString(), scoreboard.toString());

        // Should be added previous match to finished matches list
        Assertions.assertEquals(match.toString() + '\n', scoreboard.getSummary());
    }

    @Test
    @DisplayName("Should return correct string representation")
    void shouldReturnCorrectStringRepresentation() {
        Assertions.assertEquals("Home _ - Away _", scoreboard.toString());

        Match match = matches.get(0);
        scoreboard.startGame(match);

        Assertions.assertEquals(match.toString(), scoreboard.toString());
    }
}
