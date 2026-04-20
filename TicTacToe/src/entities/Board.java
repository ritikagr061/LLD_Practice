package entities;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Character>> board = new ArrayList<>(3);
    public Board(){
        for(int i=0;i<3;i++){
            ArrayList<Character> row = new ArrayList<>(3);
            for(int j=0;j<3;j++){
                row.add(null);
            }
            board.add(row);
        }
    }

    public void printBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Character cell = board.get(i).get(j);
                System.out.print((cell == null ? "-" : cell) + " ");
            }
            System.out.println();
        }
    }

    public Character checkForVerticals(){
        for(int i=0;i<3;i++){ //i=column
            Character firstElement = board.get(0).get(i);
            Boolean isWin=true;
            for(int j=1;j<=2;j++){
                if(firstElement!=board.get(j).get(i)){
                    isWin = false;
                    break;
                }
            }
            if(isWin){
                return firstElement;
            }
        }
        return null;
    }

    public Character checkForHorizontal(){
        for(int i=0;i<3;i++){
            Character firstElement = board.get(i).get(0);
            Boolean isWin = true;
            for(int j=1;j<3;j++){
                if(firstElement!=board.get(i).get(j)){
                    isWin = false;
                    break;
                }
            }
            if(isWin){
                return firstElement;
            }
        }
        return null;
    }

    public Character checkForDiagonal(){
        Character firstElement = board.get(0).get(0);
        int row=0,col=0;
        boolean isWin = true;
        for(int i=0;i<3;i++){
            if(firstElement!=board.get(row++).get(col++)){
                isWin=false;
                break;
            }
        }
        if(isWin)
            return firstElement;
        isWin = true;
        row=0;col=2;
        firstElement = board.get(row).get(col);
        for(int i=0;i<3;i++){
            if(firstElement!=board.get(row++).get(col--)){
                isWin=false;
                break;
            }
        }
        if(isWin)
            return firstElement;

        return null;
    }

    public Boolean checkIfBoardFilledCompletely(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board.get(i).get(j)==null)
                    return false;
            }
        }
        return true;
    }

    public void setEntry(int i,int j,Character c){
        board.get(i).set(j,c);
    }
}
