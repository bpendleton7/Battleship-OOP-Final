package com.example.battleship;

public class Person extends Player {

    public Person() {}

    public Person(String name, Board board) {
        super(name, board);
    }

    protected boolean userPlacePiece(Ship s,String direction,int row,int col) {
        return board.placeShip(s,direction,row,col);
    }
    public void attack(int row,int col){
        board.checkForHit(row,col);
    }
}
