package com.company;

import com.company.worldcup.Match;
import com.company.worldcup.Scoreboard;
import com.company.worldcup.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        Scoreboard scoreboard = new Scoreboard();

        List<Match> plannedMatches = new ArrayList<>(Arrays.asList(
                new Match(new Team("Mexico"), new Team("Canada")),
                new Match(new Team("Spain"), new Team("Brazil")),
                new Match(new Team("Germany"), new Team("France")),
                new Match(new Team("Uruguay"), new Team("Italy")),
                new Match(new Team("Argentina"), new Team("Australia"))
        ));

        for (Match plannedMatch : plannedMatches) {
            scoreboard.startGame(plannedMatch);
            scoreboard.updateScore(random.nextInt(11), random.nextInt(11));
            scoreboard.finishGame();
        }

        System.out.println(scoreboard.getSummary());
    }
}
