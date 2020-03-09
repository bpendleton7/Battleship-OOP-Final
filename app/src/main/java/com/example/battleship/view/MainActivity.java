package com.example.battleship.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.battleship.R;
import com.example.battleship.controller.Game;

public class MainActivity extends AppCompatActivity {

    private EditText p1Name, p2Name;
    static Game game;

    /**Main Activity onCreate has a feature for audio that was added.*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGuiComponents();
        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.lastmoh);
        mediaPlayer.start();
    }

    public void initGuiComponents(){
        p1Name = findViewById(R.id.txt_player1);
        p2Name = findViewById(R.id.txt_player2);
    }

    /**The next two methods are onClick to take to set ships pages for PVP or PVC
     * Set player names will reassure that each player has a name throughout the game.
     * Which in end result will show the player name of the winner.*/

    public void personVsPersonOnClick(View v) {
        Game currentGame = new Game("PvP");
        game = currentGame;
        setPlayerNames();
        Intent intent = new Intent(this,PlayerOneSetShips.class);
        startActivity(intent);
    }

    public void personVsComputerOnClick(View v) {
        Game currentGame = new Game("PvC");
        game = currentGame;
        setPlayerNames();
        Intent intent = new Intent(this,PlayerOneSetShips.class);
        startActivity(intent);
    }

    public void setPlayerNames(){
        String p1NewName = p1Name.getText().toString();
        String p2NewName = p2Name.getText().toString();
        if(p1NewName.isEmpty() || p1NewName.equals(" ")){
            game.players[0].setName("Player 1");
        }
        else {
            game.players[0].setName(p1NewName);
        }
        if(p2NewName.isEmpty() || p2NewName.equals(" ")){
            game.players[1].setName("Player 2");
        }
        else {
            game.players[1].setName(p2NewName);
        }
        System.out.println(game.players[1].getName());
    }
}
