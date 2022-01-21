package com.company.worldcup;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    private Match currentMatch;
    private final List<Match> previousMatches = new ArrayList<>();

    public Scoreboard() {
    }

    public void startGame(Match match) {
        if (currentMatch != null)
            previousMatches.add(currentMatch);
        currentMatch = match;
    }

    // Adds homeTeamPoints and awayTeamPoints to correspond teams
    public void updateScore(int homeTeamPoints, int awayTeamPoints) {
        if (currentMatch != null) {
            int homeTeamScore = currentMatch.getHomeTeam().getScore();
            int awayTeamScore = currentMatch.getAwayTeam().getScore();
            currentMatch.getHomeTeam().setScore(homeTeamScore + homeTeamPoints);
            currentMatch.getAwayTeam().setScore(awayTeamScore + awayTeamPoints);
        }
    }

    public void finishGame() {
        if (currentMatch != null) {
            currentMatch.finish();
            previousMatches.add(currentMatch);
        }
        currentMatch = null;
    }

    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        previousMatches.stream()
                .sorted()
                .filter(Match::isFinished)
                .forEach(match -> summary.append(match).append("\n"));
        return summary.toString();
    }

    @Override
    public String toString() {
        return currentMatch != null ? currentMatch.toString() : "Home _ - Away _";
    }
}
