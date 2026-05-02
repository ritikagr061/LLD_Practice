package scoreboard;

import entities.Innings;
import entities.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Scoreboard {
    private List<Innings> innnings;
    private int currentInning = 0;
    private final int totalInnings;
    private Team teamA;
    private Team teamB;
    private int totalOver;
    public Scoreboard(int totalInnings, Team teamA, Team teamB, int over) {
        this.totalInnings =totalInnings;
        this.teamA = teamA;
        this.teamB = teamB;
        innnings = new ArrayList<>(totalInnings);
        totalOver = over;
    }

    public Innings createNextInning(Team battingTeam){
        innnings.add(new Innings(teamA,teamB,totalOver,battingTeam));
        Innings inning = innnings.getLast();
        currentInning++;
        return inning;
    }
}
