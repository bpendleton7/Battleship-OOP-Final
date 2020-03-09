package com.example.battleship;

import java.util.Random;

public class Person extends Player {

    private boolean lastAttackHit = false;
    private int col = 0;
    private int row = 0;
    private int tries = 0;
    private Random gen = new Random();

    public Person() {}

    public Person(String name, Board board) {
        super(name, board);
    }

    public void cpuAttack(){
        if(lastAttackHit){
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
            determineIfHit(0,0);
        }
    }

    public boolean determineIfHit(int col,int row){
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
                attacked = !tempHolder.equals("AlreadyHit");
            }

        }
        return tempHolder.equals("true");
    }
}
