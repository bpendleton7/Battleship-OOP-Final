package com.example.battleship;

import java.util.Random;

public class Computer extends Player {

    private Random gen = new Random();
    private boolean lastAttackHit = false;
    private int col = 0;
    private int row = 0;
    private int tries = 0;

    public Computer() {
    }

    public Computer(String name, Board board) {
        super(name, board);
    }

    /**
     * This method goes through each of the enum ships and prompts the user to place the ship
     * It will go through a while until user has placed ship. And with the additional helper method
     * we can guide the user to place the entire ship properly.
     */

    public void placeShips(){
        boolean placeCarrier = false;
        boolean placeBattleship = false;
        boolean placeCruiser = false;
        boolean placeSub = false;
        boolean placeDestroyer = false;
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
        return board.placeShip(ship,direction,gen.nextInt(10),gen.nextInt(10));
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
            col = gen.nextInt(10);
            row = gen.nextInt(10);
            tempHolder = takeTurn(row,col);
            attacked = !tempHolder.equals("AlreadyHit");
        }
        return tempHolder.equals("true");
    }
}
