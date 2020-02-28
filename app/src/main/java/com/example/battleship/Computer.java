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

    public void placeShips(){
        //Booleans ensure that the ship is placed;
        boolean placeCarrier = false;
        boolean placeBattleship = false;
        boolean placeCruiser = false;
        boolean placeSub = false;
        boolean placeDestroyer = false;
        //The while loops check to see if it is placed and if not selects a direction and calls the helper method.
        while(!placeCarrier){
            String direction = gen.nextInt(2) == 0 ? "down" : "right";
            placeCarrier = placeShipsHelper(Ship.Carrier, direction);
        }
        while(!placeBattleship){
            String direction = gen.nextInt(2) == 0 ? "down" : "right";
            placeBattleship = placeShipsHelper(Ship.Battleship, direction);
        }
        while(!placeCruiser){
            String direction = gen.nextInt(2) == 0 ? "down" : "right";
            placeCruiser = placeShipsHelper(Ship.Cruiser, direction);
        }
        while(!placeSub){
            String direction = gen.nextInt(2) == 0 ? "down" : "right";
            placeSub = placeShipsHelper(Ship.Submarine, direction);
        }
        while(!placeDestroyer){
            String direction = gen.nextInt(2) == 0 ? "down" : "right";
            placeDestroyer = placeShipsHelper(Ship.Destroyer, direction);
        }
    }

    private boolean placeShipsHelper(Ship ship,String direction){
        //Generates a row and column and then calls the board place method.
        return board.placeShip(ship,direction,gen.nextInt(10),gen.nextInt(10));
    }

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
