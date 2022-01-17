package com.company.worldcup;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    private Match currentMatch;
    private final List<Match> previousMatches = new ArrayList<>();

    public Scoreboard(Match currentMatch) {
        this.currentMatch = currentMatch;
    }

    public void startGame() {
        if (currentMatch != null)
            System.out.println(currentMatch);
        else
            System.out.println("Match not found");
    }

    public void updateScore(int homeTeamScore, int awayTeamScore) {
        if (currentMatch != null)
            currentMatch.getHomeTeam().setScore(homeTeamScore);
        if (currentMatch != null)
            currentMatch.getAwayTeam().setScore(awayTeamScore);
    }

    public void finishGame() {
        currentMatch = null;
    }

    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        previousMatches.forEach(match -> summary.append(match).append("\n"));
        return summary.toString();
    }

    public void setCurrentMatch(Match currentMatch) {
        if (currentMatch != null)
            previousMatches.add(this.currentMatch);
        this.currentMatch = currentMatch;
    }
}
