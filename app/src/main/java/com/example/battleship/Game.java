package com.example.battleship;

public class Game {
    public Player[] players = new Player[2];
    private int turn = 0;
    public Board board;

    public Game(){}

    /**
     * Overloaded Game Constructor
     * Ensures correct players types.
     * Ensures that players will no longer be null
     */

    public Game(String type){
        Player player1 = new Person();
        Player player2 = new Person();
        switch(type){
            case "PvP":
                break;
            case "PvC":
                player1 = new Person();
                player2 = new Computer();
                break;
        }
        setPlayers(player1,player2);
    }

    /** Simple method for controller to set players */

    private void setPlayers(Player one, Player two){
        players[0] = one;
        players[1] = two;
    }

    /**
     * The next three methods:
     * First, controller goes through the board to check if all pieces are hit
     * If so, we will have a win condition.
     * Second, controller will switch turns between players.
     * Last, is to get players turn.
     */

    public boolean checkForWin(){
        Board bWinBoardCheck = players[turn].getBoard();
        int[][] winBoardCheck = bWinBoardCheck.board;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if(winBoardCheck[row][col] == 4){
                   return false;
                }
                else{
                }
            }
        }
        return true;
    }

    public void switchTurns(){
        turn = turn==0 ? 1:0;
    }

    public int getTurn(){
        return turn;
    }
}
