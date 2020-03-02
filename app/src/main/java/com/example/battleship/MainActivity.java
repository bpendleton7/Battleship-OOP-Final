package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText p1Name, p2Name;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGuiComponents();
    }

    public void initGuiComponents(){
        p1Name = findViewById(R.id.txt_player1);
        p2Name = findViewById(R.id.txt_player2);
    }


    public void personVsPersonOnClick(View v) {
        game = new Game("PvP");
        game.players[0].setName(p1Name.getText().toString());
        game.players[1].setName(p2Name.getText().toString());
        Intent intent = new Intent(this,PlayerOneSetShips.class);
        startActivity(intent);
    }

    public void personVsComputerOnClick(View v) {
        game = new Game("PvC");
        game.players[0].setName(p1Name.getText().toString());
        game.players[1].setName(p2Name.getText().toString());
        Intent intent = new Intent(this,PlayerOneSetShips.class);
        startActivity(intent);
    }

    public void computerVsComputerOnClick(View v) {
        //Initializing the game variable at the top of each on click to determine which player type
        // to add to the list to avoid the null issue;
        game = new Game("CvC");
        game.players[0].setName(p1Name.getText().toString());
        game.players[1].setName(p2Name.getText().toString());
        Intent intent = new Intent(this,PlayerOnePlayScreen.class);
        startActivity(intent);
    }
}
