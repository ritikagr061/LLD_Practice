package match;
import entities.Location;
import entities.MatchState;
import entities.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import scoreboard.Scoreboard;

@Getter
@Setter
@AllArgsConstructor
public class TestMatch implements Match{
    private Location location;
    private Team teamA;
    private Team teamB;
    private Scoreboard scoreboard;
    private Team battingFirst; //todo
    private MatchState matchState;
    private int overs;

    public TestMatch(){
        overs = 10;
        matchState = MatchState.scheduled;
    }
}
