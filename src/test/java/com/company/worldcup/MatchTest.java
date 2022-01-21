package com.company.worldcup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchTest {
    private Match match;

    @BeforeEach
    void setUp() {
        String homeTeamName = "Hungary";
        String awayTeamName = "Argentina";

        Team homeTeam = new Team(homeTeamName);
        Team awayTeam = new Team(awayTeamName);

        match = new Match(homeTeam, awayTeam);
    }

    @Test
    @DisplayName("Match should be finished")
    void matchShouldBeFinished() {
        match.finish();
        Assertions.assertTrue(match.isFinished());
    }

    @Test
    @DisplayName("Should return string representation")
    void shouldReturnStringRepresentation() {
        Assertions.assertEquals(
                String.format("%s - %s", match.getHomeTeam(), match.getAwayTeam()),
                match.toString());
    }

    @Test
    @DisplayName("Should be comparable")
    void shouldBeComparable() {
        Team homeTeam = new Team("Albania");
        Team awayTeam = new Team("Pakistan");

        Match anotherMatch = new Match(homeTeam, awayTeam);

        Assertions.assertTrue(match.compareTo(anotherMatch) > 0);
    }
}
