package at.htl.football;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String filename = "bundesliga-1819.csv";

        String line;

        League league = new League();

        try(Scanner scanner = new Scanner(new FileReader("bundesliga-1819.csv"))) {
            scanner.nextLine();
            while(scanner.hasNextLine()){
               line = scanner.nextLine();


               String [] parts = line.split(";");

               String homeName = parts[1];
               String guestName = parts[2];
               int homeGoals = Integer.parseInt(parts[3]);

               int guestGoals = Integer.parseInt(parts[4]);


               Match match = new Match(homeName,guestName,homeGoals,guestGoals);
               league.addMatchResult(match);




            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        printTable(league.getTable());

    }


    private static void printTable(List<Team> teams) {
        System.out.printf("Team                  Pts   W     D    LG   F   GA   GD%n");

        for (int i = 0; i < teams.size(); i++) {
            System.out.printf("%-20s%5s%5s%5s%5s%5s%5s%5s%n", teams.get(i).getName(), teams.get(i).getPoints(), teams.get(i).getWins(),teams.get(i).getDraws(), teams.get(i).getDefeats(), teams.get(i).getGoalsShot(), teams.get(i).getGoalsReceived(), teams.get(i).getGoalDifference());
        }

        System.out.println("\n\nPts...Points, W...Won, D...Drawn, L...Lost\n" +
                "GF...Goals for, GA...Goals against, GD...Goal difference");
    }

}
