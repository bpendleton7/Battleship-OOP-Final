package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Transition extends AppCompatActivity {
    //Transition screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
    }

    public void playerOneOnClick(View v) {
        Intent intent = new Intent(this,PlayerOnePlayScreen.class);
        startActivity(intent);
    }

    public void playerTwoOnClick(View v) {
        Intent intent = new Intent(this,PlayerTwoPlayScreen.class);
        startActivity(intent);
    }
}
