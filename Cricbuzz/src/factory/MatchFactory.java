package factory;

import entities.MatchType;
import match.Match;
import match.OneDayMatch;
import match.T20Match;
import match.TestMatch;

public class MatchFactory {
    public static Match createMatch(MatchType type){
        switch (type){
            case T20:
                return new T20Match();
            case OneDay:
                return new OneDayMatch();
            case Test:
                return new TestMatch();
            default:
                return new TestMatch();

        }
    }
}
