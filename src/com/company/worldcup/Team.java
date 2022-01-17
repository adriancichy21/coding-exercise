package com.company.worldcup;

public class Team {
    private final String name;
    private int score = 0;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " " + score;
    }
}
