package at.htl.football;

public class Team  implements Comparable<Team>{

    private String name;
   private int points;
   private int wins;
   private int draws;
   private int defeats;
   private int goalsShot;
   private int goalsReceived;
   private int goalDifference;

    public Team(String name) {
        this.name = name;
    }

    public Team() {

    }

    public void addMatch(Match match){
        if(match.getHomeName().equals(name)){
            goalsShot += match.getHomeGoals();
            goalsReceived += match.getGuestGoals();
            points += match.getHomePoints();

            if(match.getHomePoints() == 3){
                wins++;
            }else if(match.getHomePoints() == 1){
                draws++;
            }else if(match.getHomePoints() == 0){
                defeats++;
            }
        }else if(match.getGuestName().equals(name)){
            goalsShot += match.getGuestGoals();
            goalsReceived += match.getHomeGoals();
            points += match.getGuestPoints();

            if(match.getGuestPoints() == 3){
                wins++;
            }else if(match.getGuestPoints() == 1){
                draws++;
            }else if(match.getGuestPoints() == 0){
                defeats++;
            }

        }
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public int getGoalDifference() {
        return (goalsShot - goalsReceived);
    }


    @Override
    public int compareTo(Team o) {
        if(this.getPoints() < o.getPoints()){
            return -1;
        }else if(this.getPoints() > o.getPoints()){
            return 1;
        }else{
            if(this.getGoalDifference()< o.getGoalDifference()){
                return -1;
            }else if(this.getGoalDifference()> o.getGoalDifference()){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
