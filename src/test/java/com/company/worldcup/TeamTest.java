package com.company.worldcup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TeamTest {
    private Team team;
    private final String teamName = "Test team";

    @BeforeEach
    void setUp() {
        team = new Team(teamName);
    }

    @Test
    @DisplayName("Should return correct string representation")
    void shouldReturnCorrectStringRepresentation() {
        Assertions.assertEquals(teamName + " " + 0, team.toString());
    }
}
