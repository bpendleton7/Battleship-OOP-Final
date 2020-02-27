package com.example.battleship;

public class Computer extends Player {

    public Computer() {
    }

    public Computer(String name, Board board) {
        super(name, board);
    }

//    @Override
//    int userPlacePiece() {
//        Random rand = new Random();
//        //use rand to generate random number of computer placement
//        return 0;
//    }
}
