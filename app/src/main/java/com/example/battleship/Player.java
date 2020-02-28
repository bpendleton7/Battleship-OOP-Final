package com.example.battleship;

public class Player {

    private String name;
    private Board board;

    public Player() {
    }

    public Player(String name, Board board) {
        this.setName(name);
        this.setBoard(board);
    }

    public String getName() {
        return name;
    }

    public boolean takeTurn(int row,int col){
        return board.checkForHit(row,col);
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Invalid user name");
        }
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

//    @Override
//    public String toString() {
//        return String.format("Player: %s\r\nBoard: %s", this.getName(),this.getBoard().toString);
//    }

    // abstract int userPlacePiece();
}
