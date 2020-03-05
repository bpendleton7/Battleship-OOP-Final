package com.example.battleship;

public class Board {
    //0 - empty | 1 - miss | 2 - hit | 3 - sink | 4 - ship
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
        int shipSize = getShipSize(ship);

        //Make sure they place it in a decent spot and no overlaps
        try {
            //check the direction they want to place the ship
            if (direction.equals("down")) {
                //for loop to place ship while making sure it doesn't overlap
                for (int i = 0; i < shipSize; i++) {
                    if (board[row][column] == 0){
                        board[row][column] = 4;
                        column ++;
                    }
                    else{
                        //if it over laps then the ship is not placed
                        throw new ArrayIndexOutOfBoundsException();
                    }
                }
            }
            //same as above just left and right
            else if(direction.equals("right")){
                for (int i = 0; i<shipSize;i++){
                    if (board[row][column] == 0){
                        board[row][column] = 4;
                        row ++;
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

    public void emptyBoard(){
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

    public String checkForHit(int row, int col){
        if(board[row][col] == 4){
            board[row][col] = 2;

        }
        else if(board[row][col]==0){
            board[row][col] = 1;
        }
        else if(board[row][col] == 1){
            return "AlreadyHit";
        }
        return board[row][col] == 4 ? "true":"false";
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

}
