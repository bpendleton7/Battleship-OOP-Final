package com.example.battleship;

public class Board {

    //setting up the basic board in a 10x10
    int[][] board = new int[][]{
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

    public boolean placeShip(Ship ship,String direction,int row,int column){
        //get the size of the ship
        int shipSize = 0;
        int intDirection = 0;
        switch(ship){
            case Carrier:
                shipSize = 5;
                break;
            case Destroyer:
                shipSize = 2;
                break;
            case Battleship:
                shipSize = 4;
                break;
            case Cruiser:
            case Submarine:
                shipSize = 3;
                break;
        }
        //Make sure they place it in a decent spot and no overlaps
        try {
            //check the direction they want to place the ship
            if (direction.equals("up") || direction.equals("down")) {
                intDirection = direction.equals("up") ? -1 : 1;
                //for loop to place ship while making sure it doesn't overlap
                for (int i = 0; i < shipSize; i++) {
                    if (board[row][column] == 0){
                        board[row][column] = 5;
                        row += intDirection;
                    }
                    else{
                        //if it over laps then the ship is not placed
                        throw new ArrayIndexOutOfBoundsException();
                    }
                }
            }
            //same as above just left and right
            else if(direction.equals("right") || direction.equals("left")){
                intDirection = direction.equals(("right")) ? 1 :-1;
                for (int i = 0; i<shipSize;i++){
                    if (board[row][column] == 0){
                        board[row][column] = 5;
                        column += intDirection;
                    }
                    else{
                        //if it over laps then the ship is not placed
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

    public void EmptyBoard(){
        // i mean it ^^^^
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                board[row][col] = 0;
            }
        }
    }

    public String viewBoard() {
        String returnable = "";
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                returnable = returnable + board[row][col];
            }
            returnable = returnable + "\r\n";
        }
        return returnable;
    }


}
