package com.example.battleship;

public class Game {
    Player[] players = new Player[2];
    int turn = 0;

    public void turns(int row,int column) {
        // players[turn].takeTurn(row,column);
        if (!checkForWin()){
            turn = turn == 1 ? 0 : 1;
        }

    }

    public boolean checkForWin(){
        int otherPlayer = turn == 1 ? 0 : 1;
        int hitCounter = 0;
        int[][] winBoardCheck = new int[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                //  winBoardCheck[row][col] = players[otherPlayer].getValue(row,col);
            }
        }

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if(winBoardCheck[row][col] == 3){
                    hitCounter++;
                }
                else{

                }
            }
        }
        return hitCounter == 17;
    }
}
