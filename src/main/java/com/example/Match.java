package com.example;

import lombok.Data;

import java.util.HashMap;

@Data
public class Match {

    private Team team1;
    private int score1;
    private Team team2;
    private int score2;

    /**
     * Returns the winning team, if its a draw, null will be returned.
     * @return winning team
     */
    public Team getWinner() {
        Team winningTeam = null;
        if (score1 > score2) {
            winningTeam = team1;
        } else if (score2 > score1) {
            winningTeam = team2;
        }
        return winningTeam;
    }
}
