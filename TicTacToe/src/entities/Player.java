package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private static final Scanner SCANNER = new Scanner(System.in);
    String name;
    Symbol symbol;

    public Player(){
        System.out.println("Input the player name: ");
        setName(SCANNER.next());
        System.out.println("Input the symbol: ");
        String sym = SCANNER.next();
        if(sym.equals("0"))
            setSymbol(new Zero());
        else
            setSymbol(new Cross());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void takeTurn(ArrayList<Integer> arr){
        System.out.println("Input row index");
        int i= SCANNER.nextInt();
        System.out.println("Input col index");
        int j= SCANNER.nextInt();
        arr.add(i);
        arr.add(j);
    }
}
