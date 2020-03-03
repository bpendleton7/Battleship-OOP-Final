package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText p1Name, p2Name;
    static Game game;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGuiComponents();
        try {
            audio();
        } catch (IOException e) {
            e.printStackTrace();
        }


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


    //audio still needs to be worked on
    public void audio() throws IOException {
        String mp3File = "raw/pirates.mp3";
        AssetManager assetMan = getAssets();
        MediaPlayer media = new MediaPlayer();
        FileInputStream mp3Stream = assetMan.openFd(mp3File).createInputStream();
        media.setDataSource(mp3Stream.getFD());
        media.prepare();
        media.start();
    }
}
