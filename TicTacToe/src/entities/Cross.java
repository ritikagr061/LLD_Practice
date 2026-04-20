package entities;

public class Cross implements Symbol{
    private final Character symbol;
    public Cross(){
        symbol = 'X';
    }
    @Override
    public Character getSymbol(){
        return symbol;
    }
}
