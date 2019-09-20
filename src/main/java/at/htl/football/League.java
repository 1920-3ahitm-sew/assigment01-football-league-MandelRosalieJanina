package at.htl.football;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class League {

private List<Team> teams = new ArrayList<>();
Team team = new Team();


public void addMatchResult(Match match){



    Team homeTeam = findOrCreateTeam(match.getHomeName());
    homeTeam.addMatch(match);
    Team guestTeam = findOrCreateTeam(match.getGuestName());
    guestTeam.addMatch(match);

}

private Team findOrCreateTeam(String teamName) {
    for (int i = 0; i < teams.size(); i++) {
        if(teams.get(i).getName().equals(teamName)){
            return teams.get(i);
        }
    }

    Team newTeam = new Team(teamName);
    teams.add(newTeam);

   return newTeam;
}

public List<Team> getTable(){


    Collections.sort(teams);
    Collections.reverse(teams);
    return teams;
}
}
