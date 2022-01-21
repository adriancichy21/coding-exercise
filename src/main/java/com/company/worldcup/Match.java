package com.company.worldcup;

public class Match implements Comparable<Match> {
    private final Team homeTeam;
    private final Team awayTeam;

    private boolean isFinished = false;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void finish() {
        isFinished = true;
    }

    public boolean isFinished() {
        return isFinished;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", homeTeam, awayTeam);
    }

    @Override
    public int compareTo(Match match) {
        return this.toString().compareTo(match.toString());
    }
}
