package entities;

public class Zero implements Symbol{
    private final Character symbol;
    public Zero(){
        symbol = '0';
    }
    @Override
    public Character getSymbol() {
        return symbol;
    }
}
