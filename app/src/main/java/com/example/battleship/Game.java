package com.example.battleship;

public class Game {
    public Player[] players = new Player[2];
    private int turn = 0;
    public Board board;
    public PlayerOneSetShips playerOneSetShips;
    public PlayerTwoSetShips playerTwoSetShips;

    public Game(){}

    public Game(String type){
        //this should ensure that players will no longer be null and put right player types.
        Player player1 = new Person();
        Player player2 = new Person();
        switch(type){
            case "PvP":
                break;
            case "PvC":
                player1 = new Person();
                player2 = new Computer();
                break;
            case "CvC":
                player1 = new Computer();
                player2 = new Computer();
                break;
        }
        setPlayers(player1,player2);
    }

    private void setPlayers(Player one, Player two){
        players[0] = one;
        players[1] = two;
    }

    public void turns(int row,int column) {
        players[turn].takeTurn(row,column);
        if (!checkForWin()){
            turn = turn == 1 ? 0 : 1;
        }

    }

    private boolean checkForWin(){
        int[][] winBoardCheck = new int[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
             //   players[turn]
            }
        }

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

}
