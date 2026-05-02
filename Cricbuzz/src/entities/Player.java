package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private String name;
    private int ballsBowled =0;
    private int wicketsTaken =0;
    private int runsScored = 0;
    private int ballsPlayed =0;
    private boolean isOnStrike = false;
    private PlayerState state;

    public Player(String n){
        state = PlayerState.isWaitingForBatting;
        name = n;
    }
}
