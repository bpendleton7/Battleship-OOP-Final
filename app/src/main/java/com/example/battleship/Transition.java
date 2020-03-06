package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.battleship.MainActivity.game;

public class Transition extends AppCompatActivity {
    //Transition screen

    private Button player1, player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        initGuiComponents();
        player1.setText(game.players[0].getName());
        player2.setText(game.players[1].getName());
        enforceTurn();
    }

    private void enforceTurn() {
        switch (game.getTurn()){
            case 0:
                player2.setClickable(false);
                break;
            case 1:
                player1.setClickable(false);
                break;
        }
    }

    public void playerOneOnClick(View v) {
        switchTurns();
        Intent intent = new Intent(this,PlayerOnePlayScreen.class);
        startActivity(intent);
    }

    public void playerTwoOnClick(View v) {
        switchTurns();
        Intent intent = new Intent(this,PlayerTwoPlayScreen.class);
        startActivity(intent);
    }

    public void initGuiComponents(){
        player1 = findViewById(R.id.buttonPlayer1);
        player2 = findViewById(R.id.buttonPlayer2);
    }

    public void switchTurns(){
        game.switchTurns();
    }
}
