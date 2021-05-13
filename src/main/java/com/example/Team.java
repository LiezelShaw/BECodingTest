package com.example;

import lombok.Data;

@Data
public class Team implements Comparable<Team> {
    private String name;
    private int points;

    public Team(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Team team) {
        int difference = points - team.getPoints();
        if (difference == 0) {
            difference = team.getName().compareTo(name);
        }
        return difference;
    }
}
