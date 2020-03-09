package com.example.battleship;

import java.util.Random;

public class Player {

    private String name;
    protected Board board = new Board();
    private boolean lastAttackHit = false;
    private int col = 0;
    private int row = 0;
    private int tries = 0;
    private Random gen = new Random();

    public Player() {
    }

    public Player(String name, Board board) {
        this.setName(name);
        this.setBoard(board);
    }

    public String getName() {
        return name;
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

    public String takeTurn(int row,int col){
        return board.checkForHit(row,col);
    }

    /**
     * CPU's attack will check for hit and if so will attempt to attack in the proper direction
     * to sink ship. And determineIfHit method will reassure CPU does not attack same spot twice.
     */

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

//    @Override
//    public String toString() {
//        return String.format("Player: %s\r\nBoard: %s", this.getName(),this.getBoard().toString);
//    }

     protected boolean userPlaceShip(Ship s, String direction, int row, int col){
        return false;
     }
}
