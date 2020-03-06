package com.example.battleship;

import java.util.Random;

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

    private boolean lastAttackHit = false;
    private int col = 0;
    private int row = 0;
    private int tries = 0;
    private Random gen = new Random();

    public void cpuAttack(){
        if(lastAttackHit){
            //switch statement circles around last hit to see which way to continue attacking
            //tries just determines which way to attack
            switch (tries){
                case 0:
                    tries++;
                    if(determineIfHit(row + 1,col)){
                        row++;
                        tries = 0;
                    }
                    break;
                case 1:
                    tries++;
                    if(determineIfHit(row -1,col)){
                        row--;
                        tries = 1;
                    }
                    break;
                case 2:
                    tries++;
                    if(determineIfHit(row,col + 1)){
                        col++;
                        tries = 2;
                    }
                    break;
                case 3:
                    tries++;
                    if(determineIfHit(row,col -1)){
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
            //if there wasn't a previous hit or no longer a good hit next to it then generate new space;
            //0's are place holders as they will be random in the next method
            determineIfHit(0,0);
        }
    }

    public boolean determineIfHit(int col,int row){
        //makes sure the cpu doesn't attack the same spot twice.
        boolean attacked = false;
        String tempHolder = "";
        while (!attacked){
            if(lastAttackHit){
                tempHolder = takeTurn(row,col);
                attacked = !tempHolder.equals("AlreadyHit");
            }
            else{
                col = gen.nextInt(10);
                row = gen.nextInt(10);
                tempHolder = takeTurn(row,col);

            }

        }
        return tempHolder.equals("true");
    }
}
