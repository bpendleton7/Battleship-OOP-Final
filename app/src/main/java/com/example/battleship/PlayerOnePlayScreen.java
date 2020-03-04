package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlayerOnePlayScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_one_play_screen);
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
