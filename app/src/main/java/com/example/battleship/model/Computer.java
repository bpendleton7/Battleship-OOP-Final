package com.example.battleship.model;

import com.example.battleship.view.Player;
import com.example.battleship.view.Board;

import java.util.Random;

public class Computer extends Player {

    private Random gen = new Random();
    //boolean to determine random or
    private boolean lastAttackHit = false;
    private int col = 0;
    private int row = 0;
    private int tries = 0;


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
        int carrierSize = 5;
        int battleShipSize = 4;
        int cruiserSize = 3;
        int subSize = 3;
        int destroyerSize = 2;
        //Generates a row and column and then calls the board place method.
        switch (ship){
            case Carrier:
                switch (direction){
                    case "right":
                        return board.placeShip(ship,direction,gen.nextInt(10-carrierSize),gen.nextInt(10));
                    case "down":
                        return board.placeShip(ship,direction,gen.nextInt(10),gen.nextInt(10-carrierSize));
                }
            case Battleship:
                switch (direction){
                    case "right":
                        return board.placeShip(ship,direction,gen.nextInt(10-battleShipSize),gen.nextInt(10));
                    case "down":
                        return board.placeShip(ship,direction,gen.nextInt(10),gen.nextInt(10-battleShipSize));
                }
            case Cruiser:
                switch (direction){
                    case "right":
                        return board.placeShip(ship,direction,gen.nextInt(10-cruiserSize),gen.nextInt(10));
                    case "down":
                        return board.placeShip(ship,direction,gen.nextInt(10),gen.nextInt(10-cruiserSize));
                }
            case Submarine:
                switch (direction){
                    case "right":
                        return board.placeShip(ship,direction,gen.nextInt(10-subSize),gen.nextInt(10));
                    case "down":
                        return board.placeShip(ship,direction,gen.nextInt(10),gen.nextInt(10-subSize));
                }
            case Destroyer:
                switch (direction){
                    case "right":
                        return board.placeShip(ship,direction,gen.nextInt(10-destroyerSize),gen.nextInt(10));
                    case "down":
                        return board.placeShip(ship,direction,gen.nextInt(10),gen.nextInt(10-destroyerSize));
                }
        }
        return false;
    }

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
            col = gen.nextInt(10);
            row = gen.nextInt(10);
            tempHolder = takeTurn(row,col);
            attacked = !tempHolder.equals("AlreadyHit");
        }
        return tempHolder.equals("true");
    }
}
