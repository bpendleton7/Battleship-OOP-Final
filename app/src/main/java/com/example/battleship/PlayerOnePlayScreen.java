package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayerOnePlayScreen extends AppCompatActivity implements View.OnClickListener{

    private Button[][] buttons = new Button[10][10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_one_play_screen);

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
        if (((Button) v).getText().toString().equals("")) {
            ((Button) v).setBackgroundColor(Color.BLUE);
        }
    }

    //View own board with contentview
    public void viewPlayer1BoardOnClick(View v) {
        setContentView(R.layout.playeroneownboard);
    }

    //Return to play screen
    public void returnOnClick(View v) {
        setContentView(R.layout.activity_player_one_play_screen);
    }

    public void doneOnClick(View v) {
        Intent intent = new Intent(this,Transition.class);
        startActivity(intent);
    }
}
