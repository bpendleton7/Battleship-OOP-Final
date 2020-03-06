package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import static com.example.battleship.MainActivity.game;

public class PlayerOneSetShips extends AppCompatActivity implements View.OnClickListener{
    private TextView header, listedShip;
    private Button[][] buttons = new Button[10][10];
    Board board = new Board();
    String direction = "right";
    private Button doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_one_set_ships);
        initGuiComponents();
        header.setText(game.players[0].getName() + ": set your ships");
        doneButton.setEnabled(false);

        for(int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {
                String buttonID = "button_" + row + col;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[row][col] = findViewById(resID);
                buttons[row][col].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
//        startActivity(new Intent(this,Pop.class));
        System.out.println(v.getTag());
        String[] id = v.getTag().toString().split("_");
        int initialRow = Integer.parseInt(id[0]);
        int initialCol = Integer.parseInt(id[1]);
        String currentShip = listedShip.getText().toString();
        if(currentShip.equals("All Ships Placed")){

        }
        else{
            try {
                int shipSize = getShipSize(currentShip);
                int counter = 0;
                boolean placingShip = game.players[0].userPlaceShip(Ship.valueOf(
                        currentShip), direction, initialRow, initialCol);
                if (!placingShip) {
                    if (direction.equals("down")) {
                        for (int row = initialRow; row < initialRow + shipSize; row++) {
                            if (buttons[row][initialCol].getText().toString().equals("")) {

                            }
                            else{
                                throw new ArrayIndexOutOfBoundsException();
                            }

                        }
                        for (int row = initialRow; row < initialRow + shipSize; row++) {
                            buttons[row][initialCol].setBackgroundColor(Color.GRAY);
                            game.players[0].board.board[row][initialCol] = 4;
                            buttons[row][initialCol].setText(" ");
                        }
                    } else if (direction.equals("right")) {
                        for (int col = initialCol; col < initialCol + shipSize; col++) {
                            if (buttons[initialRow][col].getText().toString().equals("")) {

                            }
                            else{
                                throw new ArrayIndexOutOfBoundsException();
                            }
                        }
                        for (int col = initialCol; col < initialCol + shipSize; col++) {
                            buttons[initialRow][col].setBackgroundColor(Color.GRAY);
                            game.players[0].board.board[initialRow][col] = 4;
                            buttons[initialRow][col].setText(" ");
                        }
                    }
                    placeNextShip(currentShip);
                }
            }
            catch (ArrayIndexOutOfBoundsException ex){

            }
        }
    }

    private void placeNextShip(String ship) {
        switch(ship){
            case "Carrier":
                listedShip.setText("Battleship");
                break;
            case "Battleship" :
                listedShip.setText("Cruiser");
                break;
            case "Cruiser":
                listedShip.setText("Submarine");
                break;
            case "Submarine":
                listedShip.setText("Destroyer");
                break;
            case "Destroyer":
                listedShip.setText("All Ships Placed");
                doneButton.setEnabled(true);
                break;
        }
    }

    private int getShipSize(String currentShip) {
        int shipSize = 0;
        switch(currentShip){
            case "Carrier":
                shipSize = 5;
                break;
            case "Battleship" :
                shipSize = 4;
                break;
            case "Cruiser":
            case "Submarine":
                shipSize = 3;
                break;
            case "Destroyer":
                shipSize = 2;
                break;
        }
        return shipSize;
    }



    public void doneOnClick(View v) {
        Intent intent;
        if (game.players[1] instanceof Computer){
            ((Computer)game.players[1]).placeShips();
            intent = new Intent(this,Transition.class);
            startActivity(intent);
        }
        else{
            intent = new Intent(this,PlayerTwoSetShips.class);
            startActivity(intent);
        }
    }

    public void exitOnClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void downOnClick(View v) {
       direction = "down";
    }

    public void rightOnClick(View v) {
        direction = "right";
    }

    public void resetOnClick(View v) {
        board.emptyBoard();
        Intent intent = new Intent(this,PlayerOneSetShips.class);
        startActivity(intent);
    }

    public void initGuiComponents(){
        header = findViewById(R.id.txt_header);
        listedShip = findViewById(R.id.txt_ship);
        doneButton = findViewById(R.id.button_done);
    }

    public void testing(){
    }
}
