package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Innings {
    private Team teamA;
    private Team teamB;
    private Team battingTeam;
    private Score score;
    private Double runRate= 0.0;
    private int totalBalls=0;
    private int totalBallsBowled=0;
    private List<Character> scorePerBall;
    private Player playerOnStrike;
    private Player playerOnNonStrike;
    private Player bowler;

    public Innings(Team teamA,Team teamB, int totalOvers, Team battingTeam){
        score = new Score();
        scorePerBall = new ArrayList<>();
        this.teamA = teamA;
        this.teamB = teamB;
        this.battingTeam = battingTeam;
        playerOnStrike = battingTeam.getPlayers().get(0);
        playerOnNonStrike = battingTeam.getPlayers().get(1);
        totalBalls = totalOvers*6;
        changeBowler();
    }
    public boolean isInningFinished(){
        if(totalBalls-totalBallsBowled==0||score.getWickets()==battingTeam.getPlayers().size()-1){
            return true;
        }
        return false;
    }

    public void startInnings(){
        while(!isInningFinished()){
            bowlNextBall();
            if(isOverCompleted()){
                printScores();
                changeBowler();
                strikeRotate();
            }
        }
        System.out.println("Team: " +getBattingTeam().getName() +"Scored "+score.getRuns() + " on loss of wickets: "+score.getWickets());
    }

    public boolean isOverCompleted(){
        return totalBallsBowled%6==0;
    }

    public void changeBowler(){
        System.out.println("Change of bowler, selected next index of bowler");
        int i = new Scanner(System.in).nextInt();
        setBowler(i);

    }

    public void strikeRotate(){
        Player p = playerOnStrike;
        playerOnStrike = playerOnNonStrike;
        playerOnNonStrike = p;
    }

    public void bowlNextBall(){
        System.out.println("Please input runs for ball:" + ++totalBallsBowled);
        Character c = new Scanner(System.in).next().charAt(0);
        scorePerBall.add(c);
        playerOnStrike.setBallsPlayed(playerOnStrike.getBallsPlayed()+1);
        int x = c.equals('W')?0:((c.equals('w')? 0 : c-'0' ));
        playerOnStrike.setRunsScored(playerOnStrike.getRunsScored()+x);
        if(c.equals('W')||c.equals('w')){
            score.setWickets(score.getWickets()+1);
            playerOnStrike.setState(PlayerState.isOut);
            playerOnStrike = battingTeam.getPlayers().stream().filter(p->p.getState()!=PlayerState.isOut).findFirst().get();
            return;
        }
        if(x%2==1){
            strikeRotate();
        }
        updateScore(x);
    }

    public void setBowler(int i) {
        bowler = getBowlingTeam().getPlayers().get(i);
        System.out.println("New bowler is : "+bowler.getName());
    }

    public Team getBowlingTeam(){
        if(teamA.equals(battingTeam))
            return teamB;
        else
            return teamA;
    }

    public void updateScore(int run){
        score.setRuns(score.getRuns()+run);
        runRate = score.getRuns()*6*1.00/totalBallsBowled;
    }
    public void printScores(){
        System.out.println(this.toString());
    }
}
