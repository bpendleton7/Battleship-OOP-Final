package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import static com.example.battleship.MainActivity.game;

public class PlayerTwoSetShips extends AppCompatActivity implements View.OnClickListener{
    private TextView header, listedShip;
    private Button[][] buttons = new Button[10][10];
    Board board = new Board();
    public Ship ship;
    private int clickCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_two_set_ships);
        initGuiComponents();
        header.setText(game.players[1].getName() + ": set your ships");

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
        if (((Button) v).getText().toString().equals("")) {
            ((Button) v).setBackgroundColor(Color.GRAY);
            clickCounter++;
            shipBasedOnClickCounter();
        }
    }

    public void shipBasedOnClickCounter() {
        if(clickCounter == 0) {
            listedShip.setText("Carrier");
        }
        else if(clickCounter == 1) {
            listedShip.setText("Battleship");
        }
        else if(clickCounter == 2) {
            listedShip.setText("Cruiser");
        }
        else if(clickCounter == 3) {
            listedShip.setText("Submarine");
        }
        else if(clickCounter == 4) {
            listedShip.setText("Destroyer");
        }
    }

    public void doneOnClick(View v) {
        Intent intent = new Intent(this,Transition.class);
        startActivity(intent);
    }

    public void exitOnClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void downOnClick(View v) {
        if(ship == Ship.Carrier) {
            //TODO set five spots down
        }
        else if(ship == Ship.Battleship) {
            //TODO set four spots down
        }
        else if(ship == Ship.Cruiser) {
            //TODO set three spots down
        }
        else if(ship == Ship.Submarine) {
            //TODO set three spots down
        }
        else if(ship == Ship.Destroyer) {
            //TODO set two spots down
        }
    }

    public void rightOnClick(View v) {
        if(ship == Ship.Carrier) {
            //TODO set five spots right
        }
        else if(ship == Ship.Battleship) {
            //TODO set four spots right
        }
        else if(ship == Ship.Cruiser) {
            //TODO set three spots right
        }
        else if(ship == Ship.Submarine) {
            //TODO set three spots right
        }
        else if(ship == Ship.Destroyer) {
            //TODO set two spots right
        }
    }

    public void resetOnClick(View v) {
        board.emptyBoard();
        clickCounter = 0;
    }

    public void initGuiComponents(){
        header = findViewById(R.id.txt_header);
        listedShip = findViewById(R.id.txt_ship);
    }
}
