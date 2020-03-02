package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText p1Name, p2Name;
    static Game game;

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
        setPlayerNames();
        Intent intent = new Intent(this,PlayerOneSetShips.class);
        startActivity(intent);
    }

    public void personVsComputerOnClick(View v) {
        game = new Game("PvC");
        setPlayerNames();
        Intent intent = new Intent(this,PlayerOneSetShips.class);
        startActivity(intent);
    }

    public void computerVsComputerOnClick(View v) {
        //Initializing the game variable at the top of each on click to determine which player type
        // to add to the list to avoid the null issue;
        game = new Game("CvC");
        setPlayerNames();
        Intent intent = new Intent(this,PlayerOnePlayScreen.class);
        startActivity(intent);

    }

    public void setPlayerNames(){
        String p1NewName = p1Name.getText().toString();
        String p2NewName = p2Name.getText().toString();
        game.players[0].setName(p1NewName);
        game.players[1].setName(p2NewName);
        System.out.println(game.players[1].getName());
    }
}
