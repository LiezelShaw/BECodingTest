package com.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MatchTest {

    @Test
    public void testGetWinner1() {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        Match match = new Match();
        match.setTeam1(team1);
        match.setScore1(20);
        match.setTeam2(team2);
        match.setScore2(10);
        Team winningTeam = match.getWinner();
        assertEquals(team1, winningTeam);
    }

    @Test
    public void testGetWinner2() {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        Match match = new Match();
        match.setTeam1(team1);
        match.setScore1(13);
        match.setTeam2(team2);
        match.setScore2(20);
        Team winningTeam = match.getWinner();
        assertEquals(team2, winningTeam);
    }

    @Test
    public void testGetWinnerDraw() {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        Match match = new Match();
        match.setTeam1(team1);
        match.setScore1(20);
        match.setTeam2(team2);
        match.setScore2(20);
        Team winningTeam = match.getWinner();
        assertNull(winningTeam);
    }
}
