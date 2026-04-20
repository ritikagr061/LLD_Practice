package Manager;

import entities.Board;
import entities.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public void rotateTurn(){
        if(currentPlayer==player1)
            currentPlayer=player2;
        else currentPlayer=player1;
    }

    public void printBoard(){
        board.printBoard();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public Player checkForWinOrDraw(){
        if(board.checkForVerticals()!=null){
            return getWinner(board.checkForVerticals());
        }
        if(board.checkForHorizontal()!=null){
            return getWinner(board.checkForHorizontal());
        }
        if(board.checkForDiagonal()!=null){
            return getWinner(board.checkForDiagonal());
        }
        return null;
    }

    public Player getWinner(Character c){
        if(player1.getSymbol().getSymbol()==c)
            return player1;
        else return player2;
    }

    public Boolean isEntriesFilled(){
        return board.checkIfBoardFilledCompletely();
    }

    public void manageGame(){
        board = new Board();
        player1 = new Player();
        player2 = new Player();
        currentPlayer = player1;
        System.out.println("The Game Begins!!");

        while(checkForWinOrDraw()==null&&isEntriesFilled()==false){
            ArrayList<Integer> indexes = new ArrayList<>(2);
            currentPlayer.takeTurn(indexes);
            board.setEntry(indexes.get(0), indexes.get(1), currentPlayer.getSymbol().getSymbol());
            printBoard();
            rotateTurn();
        }
        Player winner = checkForWinOrDraw();
        if(winner==null){
            System.out.println("Its a draw!!");
        }
        else System.out.println(winner.getName()+" wins the game!!");
    }
}
