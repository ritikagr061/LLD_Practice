package match;

import entities.Location;
import entities.MatchState;
import entities.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scoreboard.Scoreboard;

@Getter
@Setter
@AllArgsConstructor
public class T20Match implements Match{
    private Location location;
    private Team teamA;
    private Team teamB;
    private Scoreboard scoreboard;
    private Team battingFirst; //todo
    private MatchState matchState;
    private int overs;

    public T20Match(){
        overs = 2;
        matchState = MatchState.scheduled;

    }
    public void intialize(Team a,Team b){
        teamA =a;
        teamB =b;
        battingFirst = a;
        matchState = MatchState.inProgress;
        scoreboard = new Scoreboard(2,teamA,teamB,overs);
    }
}
