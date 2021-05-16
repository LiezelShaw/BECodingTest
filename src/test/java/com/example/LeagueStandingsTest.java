package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LeagueStandingsTest {


    private Match initLeagueTeamsAndMatch() {
        LeagueStandings leagueStandings= new LeagueStandings();
        Team team1 = leagueStandings.getTeam("TestTeam1");
        Team team2 = leagueStandings.getTeam("TestTeam2");
        Team team3 = leagueStandings.getTeam("TestTeam3");
        Match match = new Match();
        match.setTeam1(team3);
        match.setScore1(4);
        match.setTeam2(team2);
        match.setScore2(2);
        return match;
    }

    @Test
    public void testAddTeamPoints1() {
        LeagueStandings leagueStandings= new LeagueStandings();
        Team team1 = leagueStandings.getTeam("TestTeam1");
        Team team2 = leagueStandings.getTeam("TestTeam2");
        Team team3 = leagueStandings.getTeam("TestTeam3");
        Match match1 = new Match();
        match1.setTeam1(team3);
        match1.setScore1(4);
        match1.setTeam2(team2);
        match1.setScore2(2);
        leagueStandings.addTeamPoints(match1);
        Match match2 = new Match();
        match2.setTeam1(team1);
        match2.setScore1(3);
        match2.setTeam2(team2);
        match2.setScore2(3);
        leagueStandings.addTeamPoints(match2);
        assertEquals(1, team1.getPoints());
        assertEquals(1, team2.getPoints());
        assertEquals(3, team3.getPoints());
    }

    @Test
    public void testGetTeam() {
        LeagueStandings leagueStandings= new LeagueStandings();
        Team team = leagueStandings.getTeam("TestTeam");
        assertNotNull(team);
        assertEquals("TestTeam", team.getName());
        assertEquals(0, team.getPoints());
    }

    @Test
    public void testCalculateTeamStandings() {
        LeagueStandings leagueStandings= new LeagueStandings();
        Team team1 = leagueStandings.getTeam("TestTeam1");
        Team team2 = leagueStandings.getTeam("TestTeam2");
        Team team3 = leagueStandings.getTeam("TestTeam3");
        Match match1 = new Match();
        match1.setTeam1(team3);
        match1.setScore1(4);
        match1.setTeam2(team2);
        match1.setScore2(2);
        leagueStandings.addTeamPoints(match1);
        Match match2 = new Match();
        match2.setTeam1(team1);
        match2.setScore1(3);
        match2.setTeam2(team2);
        match2.setScore2(3);
        leagueStandings.addTeamPoints(match2);
        String teamStandings = leagueStandings.calculateTeamStandings();
        StringBuffer expectedTeamStandings = new StringBuffer();
        expectedTeamStandings.append("1. Team3, 3 pts\n");
        expectedTeamStandings.append("2. Team1, 1 pt\n");
        expectedTeamStandings.append("3. Team2, 1 ptx\n");
    }
}
