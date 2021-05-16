package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamTest {


    @Test
    public void testCompareTo1() {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        team1.setPoints(25);
        team2.setPoints(35);
        assertEquals(-10, team1.compareTo(team2));
    }

    @Test
    public void testCompareTo2() {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        team1.setPoints(40);
        team2.setPoints(20);
        assertEquals(20, team1.compareTo(team2));
    }

    @Test
    public void testCompareTo3() {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        team1.setPoints(5);
        team2.setPoints(5);
        assertEquals(1, team1.compareTo(team2));
    }
}
