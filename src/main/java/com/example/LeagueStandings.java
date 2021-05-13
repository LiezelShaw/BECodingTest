package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class LeagueStandings {
    public static final int SCORE_TIE = 1;
    public static final int SCORE_WIN = 3;

    private HashMap<String, Team> teamStandings;


    public LeagueStandings() {
        teamStandings = new HashMap<>();
    }

    public void addTeamPoints(Match match) {
        Team winningTeam = match.getWinner();
        if (!isNull(winningTeam)) {
            winningTeam.setPoints(winningTeam.getPoints() + SCORE_WIN);
        } else {
            Team team1 = match.getTeam1();
            team1.setPoints(team1.getPoints() + SCORE_TIE);
            Team team2 = match.getTeam2();
            team2.setPoints(team2.getPoints() + SCORE_TIE);
        }
    }

    public Team getTeam(String name) {
        Team team = teamStandings.get(name);
        if (isNull(team)) {
            team = new Team(name);
            teamStandings.put(name, team);
        }
        return team;
    }

    private void printTeamStandings() {
        List<Team> sortedTeams = teamStandings.values().stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        int count = 0;
        for (Team team : sortedTeams) {
            StringBuilder output = new StringBuilder();
            output.append(++count);
            output.append(". ").append(team.getName());
            output.append(", ").append(team.getPoints());
            if (team.getPoints() == 1) {
                output.append(" pt");
            } else {
                output.append(" pts");
            }
            System.out.println(output.toString());
        }
    }



    public static void main(String args[]) {
        try {
            int length = args.length;
            LeagueStandings leagueStandings = new LeagueStandings();
            if (length == 0) {
                System.out.println("Specify League results filename as argument");
            } else if (args.length == 1) {
                File text = new File(args[0]);
                Scanner scanner = new Scanner(text);
                scanner.useDelimiter("\\s|,|\n");
                while (scanner.hasNextLine()) {
                    Match match = new Match();
                    StringBuilder team1 = new StringBuilder(scanner.next());
                    while (!scanner.hasNextInt()) {
                        team1.append(" ").append(scanner.next());
                    }
                    match.setTeam1(leagueStandings.getTeam(team1.toString().trim()));
                    match.setScore1(scanner.nextInt());

                    StringBuilder team2 = new StringBuilder(scanner.next());
                    while (!scanner.hasNextInt()) {
                        team2.append(" ").append(scanner.next());
                    }
                    match.setTeam2(leagueStandings.getTeam(team2.toString().trim()));
                    match.setScore2(scanner.nextInt());
                    leagueStandings.addTeamPoints(match);
                }
                leagueStandings.printTeamStandings();
            } else {
                System.out.println("Invalid argument length");
            }
        } catch (FileNotFoundException f) {
            System.out.println("The file named:  " + args[0] + "could not be found!");
        }
    }

}
