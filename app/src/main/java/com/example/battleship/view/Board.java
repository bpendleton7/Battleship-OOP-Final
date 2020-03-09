package com.example.battleship.view;

import com.example.battleship.model.Ship;

public class Board {
    public int[][] board = new int[][]{
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
    };

    /**
     * placeShips method gets the size of the ship enum
     * Then it will place it in our button array
     * However, with a for loop, it also checks that it will not be placed out of bounds
     * as well as no overlaps on ships.
     * It also has the option to choose the direction of down or right.
     */

    public boolean placeShip(Ship ship, String direction, int row, int column){
        int shipSize = getShipSize(ship);
        try {
            if (direction.equals("down")) {
                for (int i = 0; i < shipSize; i++) {
                    if (board[row][column] == 0){
                        board[row][column] = 4;
                        column ++;
                    }
                    else{
                        throw new ArrayIndexOutOfBoundsException();
                    }
                }
            }
            else if(direction.equals("right")){
                for (int i = 0; i<shipSize;i++){
                    if (board[row][column] == 0){
                        board[row][column] = 4;
                        row ++;
                    }
                    else{
                        throw new ArrayIndexOutOfBoundsException();
                    }
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException ex){
            return false;
        }
        return true;
    }

    public int getShipSize(Ship ship){
        switch(ship){
            case Carrier:
                return 5;
            case Battleship:
                return 4;
            case Cruiser:
            case Submarine:
                return 3;
            case Destroyer:
                return 2;
        }
        return 0;
    }

    public void emptyBoard(){
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                board[row][col] = 0;
            }
        }
    }

    /**A method that goes through each row and column of enemy board and checks for a hit.*/

    public String checkForHit(int row, int col){
        if(board[row][col] == 1 || board[row][col] == 2){
            return "AlreadyHit";
        }
        else if(board[row][col]==0){
            board[row][col] = 1;
        }
        else if(board[row][col] == 4){
            board[row][col] = 2;
        }
        return board[row][col] == 2 ? "true":"false";
    }

}
