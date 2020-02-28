package com.example.battleship;

import java.util.Random;

public class Computer extends Player {

    Random gen = new Random();
    //boolean to determine random or
    boolean lastAttackHit = false;
    int col = 0;
    int row = 0;
    int tries = 0;

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

    public void cpuAttack(){
        if(lastAttackHit){
            //switch statement circles around last hit to see which way to continue attacking
            //tries just determines which way to attack
            switch (tries){
                case 0:
                    tries++;
                    if(takeTurn(row + 1,col)){
                        row++;
                        tries = 0;
                    }
                    break;
                case 1:
                    tries++;
                    if(takeTurn(row -1,col)){
                        row--;
                        tries = 1;
                    }
                    break;
                case 2:
                    tries++;
                    if(takeTurn(row,col + 1)){
                        col++;
                        tries = 2;
                    }
                    break;
                case 3:
                    tries++;
                    if(takeTurn(row,col -1)){
                        col--;
                        tries = 3;
                    }
                    break;
                case 4:
                    lastAttackHit = false;
                    cpuAttack();
                    break;
            }
        }
        else{
            col = gen.nextInt(10);
            row = gen.nextInt(10);
            lastAttackHit = takeTurn(row, col);
        }
    }
}
