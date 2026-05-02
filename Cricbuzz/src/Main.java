import entities.*;
import factory.MatchFactory;
import match.Match;
import match.T20Match;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        T20Match demo = (T20Match) MatchFactory.createMatch(MatchType.T20);
        demo.setLocation(new Location("Delhi","Arun Jaitely Stadium"));
        Team a= new Team();
        a.setName("India");
        a.setPlayers(List.of(new Player("Dhoni"),new Player("Virat"), new Player("Rohit")));
        Team b= new Team();
        b.setName("Australia");
        b.setPlayers(List.of(new Player("Head"),new Player("Smith"), new Player("Hussey")));
        demo.intialize(a,b);

        Innings inning1 = demo.getScoreboard().createNextInning(a);
        inning1.startInnings();
        Innings inning2 = demo.getScoreboard().createNextInning(b);
        inning2.startInnings();
    }
}